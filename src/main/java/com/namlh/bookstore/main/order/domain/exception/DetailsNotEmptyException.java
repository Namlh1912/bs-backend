package com.namlh.bookstore.main.order.domain.exception;

import com.namlh.bookstore.core.exception.BaseBookStoreException;

/**
 * Created by app on 7/22/18.
 */
public class DetailsNotEmptyException extends BaseBookStoreException {

    public DetailsNotEmptyException() {
        super("Details should not empty");
    }

    public DetailsNotEmptyException(String message) {
        super(message);
    }
}
