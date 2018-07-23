package com.namlh.bookstore.main.user.controller;

import com.namlh.bookstore.main.user.domain.usecase.CreateUser.CreateUser;
import com.namlh.bookstore.main.user.domain.usecase.CreateUser.CreateUserRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by app on 7/20/18.
 */
@RestController
@RequestMapping(Params.CLIENT_PATH + Params.USER_PATH)
public class UserClientController {

    @Autowired
    private CreateUser createUser;

    @RequestMapping(
            value = "/sign-up", method = RequestMethod.POST)
    public Observable signUp(@RequestBody CreateUserRequest request) {
        if (request != null) {
            request.setRoleCode(Params.ROLE_CUSTOMER);
        }
        return createUser.execute(request);
    }
}
