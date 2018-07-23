package com.namlh.bookstore.main.user.controller;

import com.namlh.bookstore.main.user.domain.usecase.CreateUser.CreateUserRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by nam on 7/23/18.
 */
@RestController
@RequestMapping(Params.LOGIN_PATH)
public class UserLoginController {
    @RequestMapping(method = RequestMethod.POST)
    public Observable login(@RequestBody CreateUserRequest request) {
        return Observable.create(emitter -> emitter.onNext(HttpStatus.OK.value()));
    }
}
