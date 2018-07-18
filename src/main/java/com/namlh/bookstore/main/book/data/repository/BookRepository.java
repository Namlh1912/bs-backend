package com.namlh.bookstore.main.book.data.repository;

import com.namlh.bookstore.main.book.data.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by app on 7/18/18.
 */
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
