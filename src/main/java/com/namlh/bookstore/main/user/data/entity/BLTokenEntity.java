package com.namlh.bookstore.main.user.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by app on 7/20/18.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_bltokens")
public class BLTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "valid", nullable = false)
    private Date valid;
}
