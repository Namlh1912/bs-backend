package com.namlh.bookstore.main.order.domain.usecase.FetchOrdersByCustomer;

import lombok.Data;
import lombok.NoArgsConstructor;

import static com.namlh.bookstore.utils.Params.DEFAULT_LIMIT;

/**
 * Created by app on 7/22/18.
 */
@Data
@NoArgsConstructor
public class FetchOrdersByCustomerRequest {

    private int page = 1;

    private int limit = DEFAULT_LIMIT;

    private Integer customerId;

    public FetchOrdersByCustomerRequest(Integer customerId) {
        this.customerId = customerId;
    }
}
