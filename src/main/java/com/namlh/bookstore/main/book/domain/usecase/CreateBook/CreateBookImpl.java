package com.namlh.bookstore.main.book.domain.usecase.CreateBook;

import com.namlh.bookstore.main.book.data.entity.AuthorEntity;
import com.namlh.bookstore.main.book.data.entity.BookEntity;
import com.namlh.bookstore.main.book.data.entity.CategoryEntity;
import com.namlh.bookstore.main.book.data.entity.PublisherEntity;
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

        AuthorEntity authorEntity = authorRepository.findOne(request.getAuthorId());
        if (authorEntity == null) {
            throw new BookDoestNotExistException("Author does not exist");
        }
        bookEntity.setAuthor(authorEntity);

        PublisherEntity publisherEntity = publisherRepository.findOne(request.getPublisherId());
        if (publisherEntity == null) {
            throw new BookDoestNotExistException("Publisher does not exist");
        }
        bookEntity.setPublisher(publisherEntity);

        CategoryEntity categoryEntity = categoryRepository.findOne(request.getCategoryId());
        if (categoryEntity == null) {
            throw new BookDoestNotExistException("Category does not exist");
        }
        bookEntity.setCategory(categoryEntity);
        bookEntity.setCreated(new Date());
        bookRepository.save(bookEntity);
        return new CreateBookResponse(mapper.transform(bookEntity));
    }
}
