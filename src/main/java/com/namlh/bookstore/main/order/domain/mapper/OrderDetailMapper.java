package com.namlh.bookstore.main.order.domain.mapper;

import com.namlh.bookstore.core.mapper.BaseMapper;
import com.namlh.bookstore.main.order.data.entity.OrderDetailEntity;
import com.namlh.bookstore.main.order.domain.model.OrderDetailModel;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/22/18.
 */
@Service
public final class OrderDetailMapper extends BaseMapper<OrderDetailEntity, OrderDetailModel> {

    @Override
    public OrderDetailModel transform(OrderDetailEntity entity) {
        OrderDetailModel model = null;
        if (entity != null) {
            model = new OrderDetailModel();
            model.setId(entity.getId());
            model.setOrderCode(entity.getOrder().getOrderCode());
            model.setProductId(entity.getProduct().getId());
            model.setProductName(entity.getProduct().getTitle());
            model.setQuantity(entity.getQuantity());
            model.setTotalPrice(entity.getTotalPrice());
        }
        return model;
    }
}
