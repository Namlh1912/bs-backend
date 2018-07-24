package com.namlh.bookstore.main.book.domain.usecase.CreateBook;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by app on 7/18/18.
 */
@Data
@NoArgsConstructor
public class CreateBookRequest {

    private String title;
    private float price;
    private int quantity;
    private String imageUrl;

    private String author;
    private String publisher;
    private String category;
}
