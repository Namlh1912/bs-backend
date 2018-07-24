package com.namlh.bookstore.main.book.domain.usecase.ReadBookById;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.book.domain.model.BookModel;

/**
 * Created by nam on 7/24/18.
 */
public class ReadBookByIdResponse extends BaseResponse<BookModel> {

    protected ReadBookByIdResponse(BookModel data) { super(data); }
}
