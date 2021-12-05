package com.example.FinalProject.converter;

import com.example.FinalProject.entity.UserRole;
import com.example.FinalProject.model.UserRoleModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserRoleConverter extends BaseConverter<UserRoleModel, UserRole> {
        public UserRoleConverter(Function<UserRoleModel, UserRole> fromModel, Function<UserRole, UserRoleModel> fromEntity) {
        super(fromModel, fromEntity);
    }

    public UserRoleConverter() {
            super(UserRoleConverter::convertToEntity, UserRoleConverter::convertToModel);
    }

    private static UserRoleModel convertToModel(UserRole entityToConvert) {
            if (entityToConvert == null) return null;
            return UserRoleModel.builder()
                    .roleName(entityToConvert.getRoleName())
                    .build();
    }

    private static UserRole convertToEntity(UserRoleModel modelToConvert) {
            if (modelToConvert == null) return null;
            UserRole userRole = new UserRole();
            userRole.setRoleName(modelToConvert.getRoleName());
            return userRole;
    }
}
