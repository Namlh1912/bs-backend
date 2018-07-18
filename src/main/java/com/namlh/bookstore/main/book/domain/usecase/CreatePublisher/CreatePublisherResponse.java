package com.namlh.bookstore.main.book.domain.usecase.CreatePublisher;

import com.namlh.bookstore.core.response.BaseResponse;

/**
 * Created by app on 7/18/18.
 */
public class CreatePublisherResponse extends BaseResponse<Integer> {

    protected CreatePublisherResponse(Integer data) {
        super(data);
    }
}
