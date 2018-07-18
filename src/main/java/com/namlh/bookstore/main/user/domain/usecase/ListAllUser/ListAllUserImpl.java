package com.namlh.bookstore.main.user.domain.usecase.ListAllUser;

import com.namlh.bookstore.main.user.data.repository.UserRepository;
import com.namlh.bookstore.main.user.domain.mapper.UserMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/16/18.
 */
@Service
public final class ListAllUserImpl implements ListAllUser {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public Observable<ListAllUserResponse> execute(ListAllUserRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private ListAllUserResponse toResponse(ListAllUserRequest request) {
        return new ListAllUserResponse(mapper.transform(userRepository.findAll()));
    }
}
