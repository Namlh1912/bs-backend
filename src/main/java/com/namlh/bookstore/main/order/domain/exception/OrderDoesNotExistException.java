package com.namlh.bookstore.main.order.domain.exception;

import com.namlh.bookstore.core.exception.BaseBookStoreException;

/**
 * Created by nam on 7/24/18.
 */
public class OrderDoesNotExistException extends BaseBookStoreException {

    public OrderDoesNotExistException(String message) {
        super(message);
    }
}
