package com.namlh.bookstore.main.config.security;

import com.namlh.bookstore.main.user.data.entity.BLTokenEntity;
import com.namlh.bookstore.main.user.data.repository.BLTokenRepository;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by app on 7/20/18.
 */
@Component
public class SignOutSuccessHandler implements LogoutSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(SignOutSuccessHandler.class);

    @Autowired
    private BLTokenRepository blTokenRepository;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        logger.info("header request: {}", request.getHeader(SecurityConstants.HEADER_STRING));
        logger.info("header response: {}", response.getHeader(SecurityConstants.HEADER_STRING));

        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        if (token != null) {
            token = token.replace(SecurityConstants.TOKEN_PREFIX, "");
            BLTokenEntity blToken = new BLTokenEntity();
            blToken.setToken(token);
            Date expireDate = Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            blToken.setValid(expireDate);
            blTokenRepository.save(blToken);
        }

        HttpSession session = request.getSession(false);
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        if (session != null) {
            session.invalidate();
        }
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();
        writer.write("log out successfully");
        writer.flush();
    }
}
