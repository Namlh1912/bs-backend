package com.namlh.bookstore.main.book.domain.usecase.CreateAuthor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Created by app on 7/18/18.
 */
@Data
@NoArgsConstructor
public class CreateAuthorRequest {

    @NonNull
    private String name;

    private int birthYear;


}
