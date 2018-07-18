package com.namlh.bookstore.main.book.domain.usecase.FetchListBook;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.book.domain.model.BookModel;

import java.util.List;

/**
 * Created by app on 7/18/18.
 */
public class FetchListBookResponse extends BaseResponse<List<BookModel>> {

    protected FetchListBookResponse(List<BookModel> data) {
        super(data);
    }
}
