package com.namlh.bookstore.main.book.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by app on 7/16/18.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "birth_year")
    private Integer birthYear;

}
