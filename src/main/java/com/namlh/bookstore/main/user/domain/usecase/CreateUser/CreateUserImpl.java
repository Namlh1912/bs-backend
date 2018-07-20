package com.namlh.bookstore.main.user.domain.usecase.CreateUser;

import com.namlh.bookstore.main.user.data.entity.RoleEntity;
import com.namlh.bookstore.main.user.data.entity.UserEntity;
import com.namlh.bookstore.main.user.data.repository.RoleRepository;
import com.namlh.bookstore.main.user.data.repository.UserRepository;
import com.namlh.bookstore.main.user.domain.exception.UserDoesNotExistException;
import com.namlh.bookstore.main.user.domain.mapper.UserMapper;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/13/18.
 */
@Service
public final class CreateUserImpl implements CreateUser {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper mapper;

    @Override
    public Observable<CreateUserResponse> execute(CreateUserRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private CreateUserResponse toResponse(CreateUserRequest request) throws UserDoesNotExistException {
        UserEntity entity = new UserEntity();
        entity.setUsername(request.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmail(request.getEmail());
        entity.setMobile(request.getMobile());
        entity.setAddress(request.getAddress());

        RoleEntity roleEntity = roleRepository.findByRoleCode(request.getRoleCode());
        if (roleEntity == null) {
            throw new UserDoesNotExistException("Role does not exists");
        }
        entity.setRole(roleEntity);
        userRepository.save(entity);
        return new CreateUserResponse(mapper.transform(entity));
    }
}
