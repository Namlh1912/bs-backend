package com.namlh.bookstore.main.order.domain.usecase.CreateOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by app on 7/22/18.
 */
@Data
@NoArgsConstructor
public class CreateOrderRequest {

    List<OrderDetailRequest> details = new ArrayList<>();

    @Data
    @NoArgsConstructor
    public class OrderDetailRequest {

        private Integer productId;

        private Integer quantity = 1;
    }
}
