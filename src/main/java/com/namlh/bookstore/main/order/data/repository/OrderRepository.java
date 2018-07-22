package com.namlh.bookstore.main.order.data.repository;

import com.namlh.bookstore.main.order.data.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by app on 7/22/18.
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findAllByCustomer_UsernameOrderByOrderDateDesc(String username);
}
