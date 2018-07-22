package com.namlh.bookstore.main.order.data.repository;

import com.namlh.bookstore.main.order.data.entity.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by app on 7/22/18.
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findByOrderDateBeforeOrderByOrderDate(Date date, Pageable pageable);

    List<OrderEntity> findAllByCustomer_UsernameOrderByOrderDateDesc(String username, Pageable pageable);
}
