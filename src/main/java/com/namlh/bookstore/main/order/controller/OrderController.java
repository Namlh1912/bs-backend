package com.namlh.bookstore.main.order.controller;

import com.namlh.bookstore.main.order.domain.usecase.CreateOrder.CreateOrder;
import com.namlh.bookstore.main.order.domain.usecase.CreateOrder.CreateOrderRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by app on 7/22/18.
 */
@RestController
public class OrderController {

    @Autowired
    private CreateOrder createOrder;

    @RequestMapping(
            value = Params.CLIENT_PATH + Params.ORDER_PATH,
            method = RequestMethod.POST)
    @PreAuthorize("@permissionChecker.checkCurrentUserIsCustomer()")
    public Observable createOrder(@RequestBody CreateOrderRequest request) {
        return createOrder.execute(request);
    }
}
