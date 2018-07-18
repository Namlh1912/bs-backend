package com.namlh.bookstore.main.book.domain.usecase.CreateAuthor;

import com.namlh.bookstore.core.response.BaseResponse;

/**
 * Created by app on 7/18/18.
 */
public class CreateAuthorResponse extends BaseResponse<Integer> {

    protected CreateAuthorResponse(Integer data) {
        super(data);
    }
}
