package com.namlh.bookstore.main.book.domain.usecase.CreateCategory;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Created by app on 7/18/18.
 */
@Data
@NoArgsConstructor
public class CreateCategoryRequest {

    @NonNull
    private String title;

}
