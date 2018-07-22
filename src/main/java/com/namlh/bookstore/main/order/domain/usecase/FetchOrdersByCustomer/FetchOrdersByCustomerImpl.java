package com.namlh.bookstore.main.order.domain.usecase.FetchOrdersByCustomer;

import com.namlh.bookstore.main.order.data.entity.OrderEntity;
import com.namlh.bookstore.main.order.data.repository.OrderRepository;
import com.namlh.bookstore.main.order.domain.exception.MustBeCustomerException;
import com.namlh.bookstore.main.order.domain.mapper.OrderMapper;
import com.namlh.bookstore.main.user.data.entity.UserEntity;
import com.namlh.bookstore.main.user.data.repository.UserRepository;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by app on 7/22/18.
 */
@Service
public final class FetchOrdersByCustomerImpl implements FetchOrdersByCustomer {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Observable<FetchOrdersByCustomerResponse> execute(FetchOrdersByCustomerRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private FetchOrdersByCustomerResponse toResponse(FetchOrdersByCustomerRequest request) {
        UserEntity customer = userRepository.findOne(request.getCustomerId());
        if (!Params.ROLE_CUSTOMER.equals(customer.getRole().getRoleCode())) {
            throw new MustBeCustomerException();
        }
        PageRequest pageRequest = new PageRequest(request.getPage() - 1, request.getLimit());
        List<OrderEntity> orders = orderRepository
                .findAllByCustomer_UsernameOrderByOrderDateDesc(customer.getUsername(), pageRequest);
        int totalSize = orders.size();
        int totalPage = totalSize / request.getLimit();
        int remain = totalSize % request.getLimit();
        totalPage = remain > 0 ? totalPage + 1 : totalPage;
        return new FetchOrdersByCustomerResponse(totalPage,
                request.getPage(), pageRequest.getOffset(), orderMapper.transform(orders));
    }
}
