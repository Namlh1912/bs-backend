package com.namlh.bookstore.main.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.namlh.bookstore.main.user.data.entity.UserEntity;
import com.namlh.bookstore.main.user.data.repository.UserRepository;
import com.namlh.bookstore.main.user.domain.usecase.ReadUserInfoById.ReadUserInfoById;
import com.namlh.bookstore.main.user.domain.usecase.ReadUserInfoById.ReadUserInfoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by app on 7/16/18.
 */
@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthSuccessHandler.class);

    @Autowired
    private ReadUserInfoById readUserInfoById;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
                                        final HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity user = userRepository.findByUsername(userDetails.getUsername());

        LOGGER.info("{} got is connected", user.getUsername());
        LOGGER.info("Login token: {}", response.getHeader("x-auth-token"));

        readUserInfoById.execute(new ReadUserInfoRequest(user.getId()))
            .subscribe(result -> {
                response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX
                        + JWTAuthenticationFilter.generateToken(authentication));
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                try {
                    response.getWriter().write(new ObjectMapper().writeValueAsString(result));
                    response.getWriter().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }
}
