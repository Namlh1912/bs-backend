package com.namlh.bookstore.main.user.domain.usecase.CreateUser;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Created by app on 7/13/18.
 */
@Data
@NoArgsConstructor
public class CreateUserRequest {

    @NonNull
    private String username;

    @NonNull
    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private String mobile;

    private String roleCode;
}
