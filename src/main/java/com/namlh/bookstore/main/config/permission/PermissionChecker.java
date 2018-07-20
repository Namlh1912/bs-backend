package com.namlh.bookstore.main.config.permission;

import com.namlh.bookstore.main.user.data.entity.UserEntity;
import com.namlh.bookstore.main.user.data.repository.UserRepository;
import com.namlh.bookstore.utils.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by app on 7/20/18.
 */
@Component
public class PermissionChecker {

    @Autowired
    private UserRepository userRepository;

    public boolean checkCurrentUserIsAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getPrincipal().toString();
        UserEntity userEntity = userRepository.findByUsername(username);
        return Params.ROLE_ADMIN.equals(userEntity.getRole().getRoleCode());
    }
}
