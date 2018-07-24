package com.namlh.bookstore.main.book.domain.mapper;

import com.namlh.bookstore.core.mapper.BaseMapper;
import com.namlh.bookstore.main.book.data.entity.BookEntity;
import com.namlh.bookstore.main.book.domain.model.BookModel;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/18/18.
 */
@Service
public class BookMapper extends BaseMapper<BookEntity, BookModel> {

    @Override
    public BookModel transform(BookEntity entity) {
        BookModel model = null;
        if (entity != null) {
            model = new BookModel();
            model.setId(entity.getId());
            model.setImageUrl(entity.getImageUrl());
            model.setTitle(entity.getTitle());
            model.setPrice(entity.getPrice());
            model.setAuthor(entity.getAuthor().getName());
            model.setPublisher(entity.getPublisher().getName());
            model.setType(entity.getCategory().getTitle());
        }
        return model;
    }
}
