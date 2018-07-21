package com.namlh.bookstore.main.order.domain.usecase.CreateOrder;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.order.domain.model.OrderModel;

/**
 * Created by app on 7/22/18.
 */
public class CreateOrderResponse extends BaseResponse<OrderModel> {

    protected CreateOrderResponse(OrderModel data) {
        super(data);
    }
}
