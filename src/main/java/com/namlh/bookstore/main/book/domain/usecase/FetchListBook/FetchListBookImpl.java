package com.namlh.bookstore.main.book.domain.usecase.FetchListBook;

import com.namlh.bookstore.main.book.data.repository.BookRepository;
import com.namlh.bookstore.main.book.domain.mapper.BookMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/18/18.
 */
@Service
public final class FetchListBookImpl implements FetchListBook {

    @Autowired
    private BookMapper mapper;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Observable<FetchListBookResponse> execute(FetchListBookRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private FetchListBookResponse toResponse(FetchListBookRequest request) {
        return new FetchListBookResponse(mapper.transform(bookRepository.findAll()));
    }
}
