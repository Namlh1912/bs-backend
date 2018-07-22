package com.namlh.bookstore.main.order.domain.usecase.FetchOrders;

import com.namlh.bookstore.core.response.BasePageResponse;
import com.namlh.bookstore.main.order.domain.model.OrderModel;

import java.util.List;

/**
 * Created by app on 7/23/18.
 */
public class FetchOrdersResponse extends BasePageResponse<OrderModel> {

    public FetchOrdersResponse(int totalPage, int page, int offset, List<OrderModel> data) {
        super(totalPage, page, offset, data);
    }
}
