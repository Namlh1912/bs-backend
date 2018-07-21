package com.namlh.bookstore.main.order.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by app on 7/22/18.
 */
@Data
@NoArgsConstructor
public class OrderModel {

    private Integer id;

    private String orderCode;

    private String customer;

    private Date orderDate;

    private List<OrderDetailModel> details = new ArrayList<>();
}
