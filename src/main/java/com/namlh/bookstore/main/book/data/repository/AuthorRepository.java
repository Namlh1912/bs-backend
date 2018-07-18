package com.namlh.bookstore.main.book.data.repository;

import com.namlh.bookstore.main.book.data.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by app on 7/18/18.
 */
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
