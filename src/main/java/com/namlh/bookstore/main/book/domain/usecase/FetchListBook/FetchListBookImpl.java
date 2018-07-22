package com.namlh.bookstore.main.book.domain.usecase.FetchListBook;

import com.namlh.bookstore.main.book.data.entity.BookEntity;
import com.namlh.bookstore.main.book.data.repository.BookRepository;
import com.namlh.bookstore.main.book.domain.mapper.BookMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        PageRequest pageRequest = new PageRequest(request.getPage() - 1, request.getLimit());
        List<BookEntity> books = bookRepository.findAllByCreatedBeforeOrderByCreatedDesc(new Date(), pageRequest);
        int totalSize = books.size();
        int totalPage = totalSize / request.getLimit();
        int remain = totalSize % request.getLimit();
        totalPage = remain > 0 ? totalPage + 1 : totalPage;
        return new FetchListBookResponse(totalPage, request.getPage(), pageRequest.getOffset(),
                mapper.transform(books));
    }
}
