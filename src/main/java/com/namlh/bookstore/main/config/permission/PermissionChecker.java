package com.namlh.bookstore.main.config.permission;

import com.namlh.bookstore.main.config.LoggedInChecker;
import com.namlh.bookstore.main.user.data.entity.UserEntity;
import com.namlh.bookstore.utils.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by app on 7/20/18.
 */
@Component
public class PermissionChecker {

    @Autowired
    private LoggedInChecker loggedInChecker;

    public boolean checkCurrentUserIsAdmin() {
        UserEntity userEntity = loggedInChecker.retrieveLoggedInUser();
        return userEntity != null && Params.ROLE_ADMIN.equals(userEntity.getRole().getRoleCode());
    }

    public boolean checkCurrentUserIsCustomer() {
        UserEntity userEntity = loggedInChecker.retrieveLoggedInUser();
        return userEntity != null && Params.ROLE_CUSTOMER.equals(userEntity.getRole().getRoleCode());
    }

    public boolean checkCurrentUserCustomerAndId(Integer customerId) {
        UserEntity userEntity = loggedInChecker.retrieveLoggedInUser();
        return userEntity != null && customerId.equals(userEntity.getId()) && checkCurrentUserIsCustomer();
    }
}
