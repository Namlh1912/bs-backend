package com.namlh.bookstore.main.book.domain.usecase.DeleteBook;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.book.domain.model.BookModel;

/**
 * Created by nam on 7/23/18.
 */
public class DeleteBookResponse extends BaseResponse<Boolean> {

    protected DeleteBookResponse(Boolean data){super(data);}
}
