package com.namlh.bookstore.main.book.domain.usecase.CreateBook;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.book.domain.model.BookModel;

/**
 * Created by app on 7/18/18.
 */
public class CreateBookResponse extends BaseResponse<BookModel> {

    protected CreateBookResponse(BookModel data) {
        super(data);
    }
}
