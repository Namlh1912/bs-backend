package com.namlh.bookstore.main.book.domain.usecase.FetchListBook;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Created by app on 7/18/18.
 */
@Data
@NoArgsConstructor
public class FetchListBookRequest {

    @NonNull
    private int page = 1;

    private int limit = 10;
}
