package com.namlh.bookstore.main.book.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by app on 7/18/18.
 */
@Data
@NoArgsConstructor
public class BookModel {

    private int id;
    private String imageUrl;
    private String title;
    private float price;
    private String publisher;
    private String author;
    private String category;
}
