package com.namlh.bookstore.main.user.domain.usecase.ListAllUser;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.user.domain.model.UserModel;

import java.util.List;

/**
 * Created by app on 7/16/18.
 */
public class ListAllUserResponse extends BaseResponse<List<UserModel>> {

    protected ListAllUserResponse(List<UserModel> data) {
        super(data);
    }
}
