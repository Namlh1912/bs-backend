package com.namlh.bookstore.main.book.domain.exception;

import com.namlh.bookstore.core.exception.BaseBookStoreException;

/**
 * Created by app on 7/18/18.
 */
public class BookDoestNotExistException extends BaseBookStoreException {

    public BookDoestNotExistException(String message) {
        super(message);
    }
}
