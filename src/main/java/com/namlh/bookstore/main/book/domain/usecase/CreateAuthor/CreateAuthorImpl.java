package com.namlh.bookstore.main.book.domain.usecase.CreateAuthor;

import com.namlh.bookstore.main.book.data.entity.AuthorEntity;
import com.namlh.bookstore.main.book.data.repository.AuthorRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/18/18.
 */
@Service
public final class CreateAuthorImpl implements CreateAuthor {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Observable<CreateAuthorResponse> execute(CreateAuthorRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private CreateAuthorResponse toResponse(CreateAuthorRequest request) {
        AuthorEntity entity = new AuthorEntity();
        entity.setName(request.getName());
        entity.setBirthYear(request.getBirthYear());
        authorRepository.save(entity);
        return new CreateAuthorResponse(entity.getId());
    }
}
