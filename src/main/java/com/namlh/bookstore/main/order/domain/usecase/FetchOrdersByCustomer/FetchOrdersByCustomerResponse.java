package com.namlh.bookstore.main.order.domain.usecase.FetchOrdersByCustomer;

import com.namlh.bookstore.core.response.BasePageResponse;
import com.namlh.bookstore.main.order.domain.model.OrderModel;

import java.util.List;

/**
 * Created by app on 7/22/18.
 */
public class FetchOrdersByCustomerResponse extends BasePageResponse<OrderModel> {

    public FetchOrdersByCustomerResponse(int totalPage, int page, int offset, List<OrderModel> data) {
        super(totalPage, page, offset, data);
    }
}
