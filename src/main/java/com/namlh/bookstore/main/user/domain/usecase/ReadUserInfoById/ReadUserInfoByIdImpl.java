package com.namlh.bookstore.main.user.domain.usecase.ReadUserInfoById;

import com.namlh.bookstore.main.user.data.entity.UserEntity;
import com.namlh.bookstore.main.user.data.repository.UserRepository;
import com.namlh.bookstore.main.user.domain.exception.UserDoesNotExistException;
import com.namlh.bookstore.main.user.domain.mapper.UserMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/13/18.
 */
@Service
public final class ReadUserInfoByIdImpl implements ReadUserInfoById {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Observable<ReadUserInfoResponse> execute(ReadUserInfoRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private ReadUserInfoResponse toResponse(ReadUserInfoRequest request) throws UserDoesNotExistException {
        UserEntity entity = userRepository.findOne(request.getId());
        if (entity == null) {
            throw new UserDoesNotExistException();
        }
        return new ReadUserInfoResponse(userMapper.transform(entity));
    }
}
