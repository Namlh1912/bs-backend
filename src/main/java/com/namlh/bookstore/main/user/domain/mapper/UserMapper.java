package com.namlh.bookstore.main.user.domain.mapper;

import com.namlh.bookstore.core.mapper.BaseMapper;
import com.namlh.bookstore.main.user.data.entity.UserEntity;
import com.namlh.bookstore.main.user.domain.model.UserModel;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/13/18.
 */
@Service
public class UserMapper extends BaseMapper<UserEntity, UserModel> {

    @Override
    public UserModel transform(UserEntity entity) {
        UserModel model = null;
        if (entity != null) {
            model = new UserModel();
            model.setUsername(entity.getUsername());
            model.setFirstName(entity.getFirstName());
            model.setLastName(entity.getLastName());
            model.setId(entity.getId());
            model.setEmail(entity.getEmail());
            model.setMobile(entity.getMobile());
            model.setStartedDate(entity.getStartedDate());
            model.setAddress(entity.getAddress());
            model.setRoleTitle(entity.getRole().getRoleTitle());
        }
        return model;
    }
}
