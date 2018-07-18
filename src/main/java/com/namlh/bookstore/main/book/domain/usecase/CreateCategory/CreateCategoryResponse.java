package com.namlh.bookstore.main.book.domain.usecase.CreateCategory;

import com.namlh.bookstore.core.response.BaseResponse;

/**
 * Created by app on 7/18/18.
 */
public class CreateCategoryResponse extends BaseResponse<Integer> {

    protected CreateCategoryResponse(Integer data) {
        super(data);
    }
}
