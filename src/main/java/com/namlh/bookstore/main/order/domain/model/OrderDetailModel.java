package com.namlh.bookstore.main.order.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by app on 7/22/18.
 */
@Data
@NoArgsConstructor
public class OrderDetailModel {

    private Integer id;

    private String orderCode;

    private Integer productId;

    private String productName;

    private Integer quantity;

    private Float totalPrice;
}
