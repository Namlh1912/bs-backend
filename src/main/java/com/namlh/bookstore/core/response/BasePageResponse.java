package com.namlh.bookstore.core.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by app on 7/22/18.
 */
@Getter
@Setter
public abstract class BasePageResponse<T> {

    private int totalPage;

    private int page;

    private int offset;

    private List<T> data;

    public BasePageResponse(int totalPage, int page, List<T> data) {
        this.totalPage = totalPage;
        this.page = page;
        this.data = data;
    }

    public BasePageResponse(int totalPage, int page, int offset, List<T> data) {
        this.totalPage = totalPage;
        this.page = page;
        this.offset = offset;
        this.data = data;
    }
}
