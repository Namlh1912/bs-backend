package com.namlh.bookstore.main.user.controller;

import com.namlh.bookstore.main.user.domain.usecase.CreateUser.CreateUser;
import com.namlh.bookstore.main.user.domain.usecase.CreateUser.CreateUserRequest;
import com.namlh.bookstore.main.user.domain.usecase.ListAllUser.ListAllUser;
import com.namlh.bookstore.main.user.domain.usecase.ListAllUser.ListAllUserRequest;
import com.namlh.bookstore.main.user.domain.usecase.ReadUserInfoById.ReadUserInfoById;
import com.namlh.bookstore.main.user.domain.usecase.ReadUserInfoById.ReadUserInfoRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by app on 7/13/18.
 */
@RestController
@RequestMapping(Params.USER_PATH)
public class UserController {

    @Autowired
    private ListAllUser listAllUser;

    @Autowired
    private ReadUserInfoById readUserInfoById;

    @Autowired
    private CreateUser createUser;

    @RequestMapping(method = RequestMethod.GET)
    public Observable listAllUser() {
        return listAllUser.execute(new ListAllUserRequest());
    }

    @RequestMapping(
            value = "/{userId}", method = RequestMethod.GET)
    public Observable readUserInfo(@PathVariable("userId") Integer userId) {
        return readUserInfoById.execute(new ReadUserInfoRequest(userId));
    }

    @RequestMapping(
            value = "/login", method = RequestMethod.POST)
    public Observable login(@RequestBody CreateUserRequest request) {
        return Observable.create(emitter -> emitter.onNext(HttpStatus.OK.value()));
    }

    @RequestMapping(
            value = "/sign-up", method = RequestMethod.POST)
    public Observable signUp(@RequestBody CreateUserRequest request) {
        return createUser.execute(request);
    }
}
