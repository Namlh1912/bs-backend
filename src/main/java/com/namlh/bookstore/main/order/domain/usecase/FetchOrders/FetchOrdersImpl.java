package com.namlh.bookstore.main.order.domain.usecase.FetchOrders;

import com.namlh.bookstore.main.order.data.entity.OrderEntity;
import com.namlh.bookstore.main.order.data.repository.OrderRepository;
import com.namlh.bookstore.main.order.domain.mapper.OrderMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by app on 7/23/18.
 */
@Service
public final class FetchOrdersImpl implements FetchOrders {

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Observable<FetchOrdersResponse> execute(FetchOrdersRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private FetchOrdersResponse toResponse(FetchOrdersRequest request) {
        PageRequest pageRequest = new PageRequest(request.getPage() - 1, request.getLimit());
        List<OrderEntity> orders = orderRepository
                .findByOrderDateBeforeOrderByOrderDate(new Date(), pageRequest);
        int totalSize = orders.size();
        int totalPage = totalSize / request.getLimit();
        int remain = totalSize % request.getLimit();
        totalPage = remain > 0 ? totalPage + 1 : totalPage;
        return new FetchOrdersResponse(totalPage, request.getPage(), pageRequest.getOffset(),
                mapper.transform(orders));
    }
}
