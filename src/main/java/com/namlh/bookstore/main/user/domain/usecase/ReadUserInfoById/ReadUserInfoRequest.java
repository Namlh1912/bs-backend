package com.namlh.bookstore.main.user.domain.usecase.ReadUserInfoById;

import lombok.Data;

/**
 * Created by app on 7/13/18.
 */
@Data
public class ReadUserInfoRequest {

    private Integer id;

    public ReadUserInfoRequest(Integer id) {
        this.id = id;
    }
}
