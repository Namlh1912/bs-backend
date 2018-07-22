package com.namlh.bookstore.main.book.domain.usecase.FetchListBook;

import com.namlh.bookstore.core.response.BasePageResponse;
import com.namlh.bookstore.main.book.domain.model.BookModel;

import java.util.List;

/**
 * Created by app on 7/18/18.
 */
public class FetchListBookResponse extends BasePageResponse<BookModel> {

    public FetchListBookResponse(int totalPage, int page, int offset, List<BookModel> data) {
        super(totalPage, page, offset, data);
    }
}
