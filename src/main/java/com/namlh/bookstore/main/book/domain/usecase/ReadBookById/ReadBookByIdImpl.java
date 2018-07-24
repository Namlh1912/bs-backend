package com.namlh.bookstore.main.book.domain.usecase.ReadBookById;

import com.namlh.bookstore.main.book.data.entity.BookEntity;
import com.namlh.bookstore.main.book.data.repository.BookRepository;
import com.namlh.bookstore.main.book.domain.exception.BookDoestNotExistException;
import com.namlh.bookstore.main.book.domain.mapper.BookMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nam on 7/24/18.
 */
@Service
public class ReadBookByIdImpl implements ReadBookById{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Observable<ReadBookByIdResponse> execute(ReadBookByIdRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private ReadBookByIdResponse toResponse(ReadBookByIdRequest request) throws BookDoestNotExistException {
        BookEntity entity = bookRepository.findOne(request.getId());
        if (entity == null) {
            throw new BookDoestNotExistException("Book does not exist");
        }
        return new ReadBookByIdResponse(bookMapper.transform(entity));
    }
}
