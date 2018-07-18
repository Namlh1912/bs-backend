package com.namlh.bookstore.main.user.domain.usecase.CreateUser;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.user.domain.model.UserModel;

/**
 * Created by app on 7/13/18.
 */
public class CreateUserResponse extends BaseResponse<UserModel> {

    protected CreateUserResponse(UserModel data) {
        super(data);
    }
}
