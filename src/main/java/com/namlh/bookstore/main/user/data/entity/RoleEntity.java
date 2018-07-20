package com.namlh.bookstore.main.user.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by app on 7/20/18.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_title", nullable = false)
    private String roleTitle;

    @Column(name = "role_code", unique = true, nullable = false)
    private String roleCode;
}
