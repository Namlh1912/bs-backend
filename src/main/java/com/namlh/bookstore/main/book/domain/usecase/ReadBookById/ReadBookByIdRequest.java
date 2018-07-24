package com.namlh.bookstore.main.book.domain.usecase.ReadBookById;

import lombok.Data;

/**
 * Created by nam on 7/24/18.
 */
@Data
public class ReadBookByIdRequest {

    private Integer id;

    public ReadBookByIdRequest(Integer id) { this.id = id; }

}
