package com.namlh.bookstore.main.order.controller;

import com.namlh.bookstore.main.order.domain.usecase.CreateOrder.CreateOrder;
import com.namlh.bookstore.main.order.domain.usecase.CreateOrder.CreateOrderRequest;
import com.namlh.bookstore.main.order.domain.usecase.FetchOrdersByCustomer.FetchOrdersByCustomer;
import com.namlh.bookstore.main.order.domain.usecase.FetchOrdersByCustomer.FetchOrdersByCustomerRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by app on 7/22/18.
 */
@RestController
public class OrderController {

    @Autowired
    private CreateOrder createOrder;

    @Autowired
    private FetchOrdersByCustomer fetchOrdersByCustomer;

    @RequestMapping(
            value = Params.CLIENT_PATH + Params.ORDER_PATH,
            method = RequestMethod.POST)
    @PreAuthorize("@permissionChecker.checkCurrentUserIsCustomer()")
    public Observable createOrder(
            @RequestBody CreateOrderRequest request) {
        return createOrder.execute(request);
    }

    @RequestMapping(
            value = Params.CLIENT_PATH + Params.ORDER_PATH + "/{customerId}",
            method = RequestMethod.GET)
    @PreAuthorize("@permissionChecker.checkCurrentUserCustomerAndId(#customerId)")
    public Observable fetchOrdersByCustomer(
            @PathVariable("customerId") Integer customerId) {
        return fetchOrdersByCustomer.execute(new FetchOrdersByCustomerRequest(customerId));
    }
}
