package com.namlh.bookstore.core.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by app on 7/13/18.
 */
@Getter
@Setter
public abstract class BaseResponse<T> {

    protected T data;

    protected BaseResponse(T data) {
        this.data = data;
    }
}
