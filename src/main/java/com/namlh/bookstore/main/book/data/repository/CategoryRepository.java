package com.namlh.bookstore.main.book.data.repository;

import com.namlh.bookstore.main.book.data.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by app on 7/18/18.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
