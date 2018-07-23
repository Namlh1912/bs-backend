package com.namlh.bookstore.main.book.domain.usecase.EditBook;

import com.namlh.bookstore.core.response.BaseResponse;
import com.namlh.bookstore.main.book.domain.model.BookModel;

/**
 * Created by nam on 7/24/18.
 */
public class EditBookResponse extends BaseResponse<BookModel>{

    protected EditBookResponse (BookModel data){
        super(data);
    }
}
