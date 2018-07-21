package com.namlh.bookstore.main.order.data.entity;

import com.namlh.bookstore.main.user.data.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by app on 7/22/18.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_code", nullable = false, unique = true)
    private String orderCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private UserEntity customer;

    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderDetailEntity> details = new ArrayList<>();

    public void addDetail(OrderDetailEntity detail) {
        this.details.add(detail);
        detail.setOrder(this);
    }
}
