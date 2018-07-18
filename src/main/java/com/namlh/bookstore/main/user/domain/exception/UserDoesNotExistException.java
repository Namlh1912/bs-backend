package com.namlh.bookstore.main.user.domain.exception;

import com.namlh.bookstore.core.exception.BaseBookStoreException;

/**
 * Created by app on 7/13/18.
 */
public class UserDoesNotExistException extends BaseBookStoreException {

    public UserDoesNotExistException() {
        super("User does not exists!");
    }

    public UserDoesNotExistException(String message) {
        super(message);
    }
}
