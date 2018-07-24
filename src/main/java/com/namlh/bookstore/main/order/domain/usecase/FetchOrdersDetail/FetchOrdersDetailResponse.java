package com.namlh.bookstore.main.order.domain.usecase.FetchOrdersDetail;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.order.domain.model.OrderModel;

/**
 * Created by nam on 7/24/18.
 */
public class FetchOrdersDetailResponse extends BaseResponse<OrderModel> {
    protected FetchOrdersDetailResponse (OrderModel data) { super(data); }
}
