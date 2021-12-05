package com.example.FinalProject.service.impl;

import com.example.FinalProject.converter.UserConverter;
import com.example.FinalProject.entity.User;
import com.example.FinalProject.model.UserModel;
import com.example.FinalProject.repository.UserRepository;
import com.example.FinalProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel createUser(UserModel userModel) {
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        userRepository.save(userConverter.convertFromModel(userModel));
        return userModel;
    }

    @Override
    public List<UserModel> getAll() {
        List<UserModel> userModels = new ArrayList<>();
        for (User user:userRepository.findAll()) {
            userModels.add(userConverter.convertFromEntity(user));
        }
        return userModels;
    }

    @Override
    public UserModel getById(Long id) {
        return userConverter.convertFromEntity(userRepository.findById(id).orElse(null));
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        UserModel userModelForUpdate = getById(userConverter.convertFromModel(userModel).getId());

        if (userModel.getFullName() != null) userModelForUpdate.setFullName(userModel.getFullName());
        if (userModel.getLogin() != null) userModelForUpdate.setLogin(userModel.getLogin());
        if (userModel.getPassword() != null) userModelForUpdate.setPassword(userModel.getPassword());
        if (userModel.getUserRoleId() != null) userModelForUpdate.setUserRoleId(userModel.getUserRoleId());

        userRepository.save(userConverter.convertFromModel(userModelForUpdate));
        return userModelForUpdate;
    }

    @Override
    public UserModel deleteById(Long id) {
        UserModel userModelForDelete = getById(id);
        if (userModelForDelete != null) userRepository.delete(userConverter.convertFromModel(userModelForDelete));

        return userModelForDelete;
    }
}
