package com.namlh.bookstore.main.order.domain.mapper;

import com.namlh.bookstore.core.mapper.BaseMapper;
import com.namlh.bookstore.main.order.data.entity.OrderEntity;
import com.namlh.bookstore.main.order.domain.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/22/18.
 */
@Service
public final class OrderMapper extends BaseMapper<OrderEntity, OrderModel> {

    @Autowired
    private OrderDetailMapper detailMapper;

    @Override
    public OrderModel transform(OrderEntity entity) {
        OrderModel model = null;
        if (entity != null) {
            model = new OrderModel();
            model.setId(entity.getId());
            model.setCustomer(entity.getCustomer().getUsername());
            model.setOrderCode(entity.getOrderCode());
            model.setOrderDate(entity.getOrderDate());
            model.setDetails(detailMapper.transform(entity.getDetails()));
        }
        return model;
    }
}
