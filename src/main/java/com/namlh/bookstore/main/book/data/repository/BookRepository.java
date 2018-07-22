package com.namlh.bookstore.main.book.data.repository;

import com.namlh.bookstore.main.book.data.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by app on 7/18/18.
 */
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    List<BookEntity> findAllByCreatedBeforeOrderByCreatedDesc(Date date, Pageable pageable);
}
