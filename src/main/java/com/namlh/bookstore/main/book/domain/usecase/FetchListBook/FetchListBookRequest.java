package com.namlh.bookstore.main.book.domain.usecase.FetchListBook;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by app on 7/18/18.
 */
@Data
@NoArgsConstructor
public class FetchListBookRequest {

    private int page = 1;

    private int limit = 10;
}
