package com.namlh.bookstore.main.order.domain.usecase.CreateOrder;

import com.namlh.bookstore.main.book.data.entity.BookEntity;
import com.namlh.bookstore.main.book.data.repository.BookRepository;
import com.namlh.bookstore.main.book.domain.exception.BookDoestNotExistException;
import com.namlh.bookstore.main.config.LoggedInChecker;
import com.namlh.bookstore.main.config.permission.PermissionChecker;
import com.namlh.bookstore.main.order.data.entity.OrderDetailEntity;
import com.namlh.bookstore.main.order.data.entity.OrderEntity;
import com.namlh.bookstore.main.order.data.repository.OrderRepository;
import com.namlh.bookstore.main.order.domain.exception.DetailsNotEmptyException;
import com.namlh.bookstore.main.order.domain.exception.MustBeCustomerException;
import com.namlh.bookstore.main.order.domain.mapper.OrderMapper;
import com.namlh.bookstore.main.user.data.entity.UserEntity;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.namlh.bookstore.utils.Params.ORDER_PREFIX;

/**
 * Created by app on 7/22/18.
 */
@Service
public final class CreateOrderImpl implements CreateOrder {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private LoggedInChecker loggedInChecker;

    @Autowired
    private PermissionChecker permissionChecker;

    @Override
    public Observable<CreateOrderResponse> execute(CreateOrderRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private CreateOrderResponse toResponse(CreateOrderRequest request) throws MustBeCustomerException,
            DetailsNotEmptyException, BookDoestNotExistException {
        if (!permissionChecker.checkCurrentUserIsCustomer()) {
            throw new MustBeCustomerException();
        }

        if (request.getDetails().size() <= 0) {
            throw new DetailsNotEmptyException();
        }

        UserEntity customer = loggedInChecker.retrieveLoggedInUser();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomer(customer);
        for (CreateOrderRequest.OrderDetailRequest detail: request.getDetails()) {
            OrderDetailEntity detailEntity = new OrderDetailEntity();
            BookEntity product = bookRepository.findOne(detail.getProductId());
            if (product == null) {
                throw new BookDoestNotExistException("Book does not exits");
            }
            detailEntity.setProduct(product);
            detailEntity.setQuantity(detail.getQuantity());
            detailEntity.setTotalPrice(product.getPrice() * detail.getQuantity());
            orderEntity.addDetail(detailEntity);
        }
        orderEntity.setOrderDate(new Date());
        orderRepository.save(orderEntity);
        orderEntity.setOrderCode(ORDER_PREFIX + String.valueOf(orderEntity.getOrderDate().getTime())
                + "_" + String.valueOf(orderEntity.getId()));
        orderRepository.save(orderEntity);
        return new CreateOrderResponse(mapper.transform(orderEntity));
    }
}
