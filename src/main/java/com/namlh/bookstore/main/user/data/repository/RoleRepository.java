package com.namlh.bookstore.main.user.data.repository;

import com.namlh.bookstore.main.user.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by app on 7/20/18.
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByRoleCode(String roleCode);
}
