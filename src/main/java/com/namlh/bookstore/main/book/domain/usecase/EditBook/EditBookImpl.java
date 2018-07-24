package com.namlh.bookstore.main.book.domain.usecase.EditBook;

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

/**
 * Created by nam on 7/24/18.
 */

@Service
public final class EditBookImpl implements EditBook {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Observable<EditBookResponse> execute(EditBookRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private EditBookResponse toResponse(EditBookRequest request) throws BookDoestNotExistException {

        BookEntity bookEntity = bookRepository.findOne(request.getBookId());
        if(bookEntity == null ){
            throw new BookDoestNotExistException("Book does not exist");
        }
        bookEntity.setTitle(request.getTitle());
        bookEntity.setPrice(request.getPrice());
        bookEntity.setImageUrl(request.getImageUrl());
        bookEntity.setQuantity(request.getQuantity());

        bookEntity.setAuthor(request.getAuthor());
        bookEntity.setPublisher(request.getPublisher());
        bookEntity.setCategory(request.getCategory());

        bookRepository.save(bookEntity);
        return new EditBookResponse(bookMapper.transform(bookEntity));
    }


}
