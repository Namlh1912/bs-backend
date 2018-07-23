package com.namlh.bookstore.main.book.domain.usecase.DeleteBook;

import com.namlh.bookstore.main.book.data.entity.BookEntity;
import com.namlh.bookstore.main.book.data.repository.BookRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nam on 7/23/18.
 */
@Service
public final class DeleteBookImpl implements DeleteBook {

    @Autowired
    private BookRepository bookRepository ;


    @Override
    public Observable<DeleteBookResponse> execute(DeleteBookRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private DeleteBookResponse toResponse(DeleteBookRequest request){
        bookRepository.delete(request.getBookId());
        BookEntity bookEntity = bookRepository.findOne(request.getBookId());
        return new DeleteBookResponse( bookEntity == null);
    }
}
