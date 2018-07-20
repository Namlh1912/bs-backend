package com.namlh.bookstore.main.config.security;

import com.namlh.bookstore.main.user.data.entity.BLTokenEntity;
import com.namlh.bookstore.main.user.data.repository.BLTokenRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by app on 7/13/18.
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private BLTokenRepository blTokenRepository;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
                                  BLTokenRepository blTokenRepository) {
        super(authenticationManager);
        this.blTokenRepository = blTokenRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConstants.HEADER_STRING);
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        if (token != null) {
            try {
                token = token.replace(SecurityConstants.TOKEN_PREFIX, "");
                BLTokenEntity blTokenEntity = blTokenRepository.findByToken(token);
                if (blTokenEntity != null) {
                    return null;
                }
                String user = Jwts.parser()
                        .setSigningKey(SecurityConstants.SECRET.getBytes())
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }
                return null;
            } catch (ExpiredJwtException exception) {
                return null;
            }
        }
        return null;
    }
}
