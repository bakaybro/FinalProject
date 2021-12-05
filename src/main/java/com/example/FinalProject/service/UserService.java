package com.example.FinalProject.service;

import com.example.FinalProject.entity.User;
import com.example.FinalProject.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel createUser(UserModel userModel);
    List<UserModel> getAll();
    UserModel getById(Long id);
    UserModel updateUser(UserModel userModel);
    UserModel deleteById(Long id);
//    String getBasicAuthHeaderByAuthModel(UserAuthModel userAuthModel);
}
