package com.namlh.bookstore.main.order.domain.usecase.FetchOrdersDetail;

import lombok.Data;

/**
 * Created by nam on 7/24/18.
 */
@Data
public class FetchOrdersDetailRequest {

    private Integer id;

    public FetchOrdersDetailRequest(Integer id) {this.id = id;}
}
