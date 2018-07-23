package com.namlh.bookstore.main.order.controller;

import com.namlh.bookstore.main.order.domain.usecase.FetchOrders.FetchOrders;
import com.namlh.bookstore.main.order.domain.usecase.FetchOrders.FetchOrdersRequest;
import com.namlh.bookstore.main.order.domain.usecase.FetchOrdersByCustomer.FetchOrdersByCustomerRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.namlh.bookstore.utils.Params.DEFAULT_LIMIT;

/**
 * Created by nam on 7/24/18.
 */
@RestController
public class OrderAdminController {

    @Autowired
    private FetchOrders fetchOrders;


    @RequestMapping(
            value = Params.ADMIN_PATH + Params.ORDER_PATH,
            method = RequestMethod.GET)
    @PreAuthorize("@permissionChecker.checkCurrentUserIsAdmin()")
    public Observable fetchOrdersByAdmin(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "limit", required = false) Integer limit) {
        FetchOrdersRequest request = new FetchOrdersRequest();
        request.setPage(page == null ? 1: page);
        request.setLimit(limit == null ? DEFAULT_LIMIT : limit);
        return fetchOrders.execute(request);
    }


}
