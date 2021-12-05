package com.example.FinalProject.service;

import com.example.FinalProject.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    UserRoleModel createUserRole(UserRoleModel userRoleModel);
    List<UserRoleModel> getAll();
    UserRoleModel getById(Long id);
    UserRoleModel updateUserRole(UserRoleModel userRoleModel);
    UserRoleModel deleteById(Long id);
}
