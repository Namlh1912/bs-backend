package com.namlh.bookstore.main.user.data.repository;

import com.namlh.bookstore.main.user.data.entity.BLTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by app on 7/20/18.
 */
public interface BLTokenRepository extends JpaRepository<BLTokenEntity, Integer> {

    BLTokenEntity findByToken(String token);
}
