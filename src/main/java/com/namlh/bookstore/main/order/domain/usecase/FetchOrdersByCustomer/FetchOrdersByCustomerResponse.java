package com.namlh.bookstore.main.order.domain.usecase.FetchOrdersByCustomer;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.order.domain.model.OrderModel;

import java.util.List;

/**
 * Created by app on 7/22/18.
 */
public class FetchOrdersByCustomerResponse extends BaseResponse<List<OrderModel>> {

    protected FetchOrdersByCustomerResponse(List<OrderModel> data) {
        super(data);
    }
}
