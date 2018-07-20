package com.namlh.bookstore.main.user.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by app on 7/13/18.
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {

    private Integer id;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    private String address;

    private String roleTitle;

    private Date startedDate;
}
