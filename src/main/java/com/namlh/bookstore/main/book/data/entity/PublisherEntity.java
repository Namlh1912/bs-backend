package com.namlh.bookstore.main.book.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by app on 7/17/18.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_publisher")
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

}
