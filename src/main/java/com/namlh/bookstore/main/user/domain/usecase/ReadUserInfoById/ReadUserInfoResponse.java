package com.namlh.bookstore.main.user.domain.usecase.ReadUserInfoById;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.user.domain.model.UserModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by app on 7/13/18.
 */
public class ReadUserInfoResponse extends BaseResponse<UserModel> {

    protected ReadUserInfoResponse(UserModel data) {
        super(data);
    }
}
