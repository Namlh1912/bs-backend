package com.namlh.bookstore.main.order.domain.usecase.FetchOrdersByCustomer;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by app on 7/22/18.
 */
@Data
@NoArgsConstructor
public class FetchOrdersByCustomerRequest {

    private Integer customerId;
}
