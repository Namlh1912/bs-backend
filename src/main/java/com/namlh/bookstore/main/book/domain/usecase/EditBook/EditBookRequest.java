package com.namlh.bookstore.main.book.domain.usecase.EditBook;

import lombok.Data;

/**
 * Created by nam on 7/24/18.
 */
@Data
public class EditBookRequest {

    private int bookId;
    private String title;
    private float price;
    private int quantity;
    private String imageUrl;

    private String author;
    private String publisher;
    private String category;
}
