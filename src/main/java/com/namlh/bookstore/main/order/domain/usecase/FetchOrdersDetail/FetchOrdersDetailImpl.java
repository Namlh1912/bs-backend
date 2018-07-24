package com.namlh.bookstore.main.order.domain.usecase.FetchOrdersDetail;

import com.namlh.bookstore.main.order.data.entity.OrderEntity;
import com.namlh.bookstore.main.order.data.repository.OrderRepository;
import com.namlh.bookstore.main.order.domain.exception.OrderDoesNotExistException;
import com.namlh.bookstore.main.order.domain.mapper.OrderMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nam on 7/24/18.
 */
@Service
public class FetchOrdersDetailImpl implements FetchOrdersDetail {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public Observable<FetchOrdersDetailResponse> execute(FetchOrdersDetailRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private FetchOrdersDetailResponse toResponse(FetchOrdersDetailRequest request) throws OrderDoesNotExistException{
        OrderEntity entity = orderRepository.findOne(request.getId());
        if(entity == null){
            throw new OrderDoesNotExistException("Order does not exist");
        }
        return new FetchOrdersDetailResponse(mapper.transform(entity));
    }
}
