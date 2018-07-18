package com.namlh.bookstore.main.user.data.repository;

import com.namlh.bookstore.main.user.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by app on 7/13/18.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
}
