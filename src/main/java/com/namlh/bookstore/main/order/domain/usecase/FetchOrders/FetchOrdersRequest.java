package com.namlh.bookstore.main.order.domain.usecase.FetchOrders;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import static com.namlh.bookstore.utils.Params.DEFAULT_LIMIT;

/**
 * Created by app on 7/23/18.
 */
@Data
@NoArgsConstructor
public class FetchOrdersRequest {

    @NonNull
    private int page = 1;

    private int limit = DEFAULT_LIMIT;
}
