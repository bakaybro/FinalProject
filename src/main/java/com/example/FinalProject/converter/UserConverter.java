package com.example.FinalProject.converter;


import com.example.FinalProject.entity.User;
import com.example.FinalProject.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserConverter extends BaseConverter<UserModel, User> {

    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToModel);
    }

    public UserConverter(Function<UserModel, User> fromModel, Function<User, UserModel> fromEntity) {
        super(fromModel, fromEntity);
    }

    private static User convertToEntity(UserModel entityToConvert) {
        return User.builder()
                .fullName(entityToConvert.getFullName())
                .login(entityToConvert.getLogin())
                .password(entityToConvert.getPassword())
                .build();
    }

    private static UserModel convertToModel(User modelToConvert) {
        return UserModel.builder()
                .fullName(modelToConvert.getFullName())
                .login(modelToConvert.getLogin())
                .password(modelToConvert.getPassword())
                .build();
    }
}
