package com.namlh.bookstore.main.book.domain.usecase.CreateBook;

import com.namlh.bookstore.main.book.data.entity.BookEntity;
import com.namlh.bookstore.main.book.data.repository.AuthorRepository;
import com.namlh.bookstore.main.book.data.repository.BookRepository;
import com.namlh.bookstore.main.book.data.repository.CategoryRepository;
import com.namlh.bookstore.main.book.data.repository.PublisherRepository;
import com.namlh.bookstore.main.book.domain.exception.BookDoestNotExistException;
import com.namlh.bookstore.main.book.domain.mapper.BookMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by app on 7/18/18.
 */
@Service
public final class CreateBookImpl implements CreateBook {

    @Autowired
    private BookMapper mapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Observable<CreateBookResponse> execute(CreateBookRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private CreateBookResponse toResponse(CreateBookRequest request) throws BookDoestNotExistException {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(request.getTitle());
        bookEntity.setPrice(request.getPrice());
        bookEntity.setImageUrl(request.getImageUrl());
        bookEntity.setQuantity(request.getQuantity());
        bookEntity.setAuthor(request.getAuthor());
        bookEntity.setPublisher(request.getPublisher());
        bookEntity.setCategory(request.getCategory());
        bookEntity.setCreated(new Date());
        bookRepository.save(bookEntity);
        return new CreateBookResponse(mapper.transform(bookEntity));
    }
}
