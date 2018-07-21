package com.namlh.bookstore.main.order.data.entity;

import com.namlh.bookstore.main.book.data.entity.BookEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by app on 7/22/18.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_order_detail")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private BookEntity product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total_price")
    private Float totalPrice;
}
