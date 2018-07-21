package com.namlh.bookstore.main.order.domain.exception;

import org.springframework.security.access.AccessDeniedException;

/**
 * Created by app on 7/22/18.
 */
public class MustBeCustomerException extends AccessDeniedException {

    public MustBeCustomerException() {
        super("Must be customer!");
    }

    public MustBeCustomerException(String msg) {
        super(msg);
    }
}
