package com.namlh.bookstore.main.config;

import com.namlh.bookstore.main.user.data.entity.UserEntity;
import com.namlh.bookstore.main.user.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by app on 7/22/18.
 */
@Component
public class LoggedInChecker {

    @Autowired
    private UserRepository userRepository;

    public UserEntity retrieveLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getPrincipal().toString();
        return userRepository.findByUsername(username);
    }
}
