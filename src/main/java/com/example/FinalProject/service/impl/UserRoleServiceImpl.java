package com.example.FinalProject.service.impl;

import com.example.FinalProject.converter.UserRoleConverter;
import com.example.FinalProject.entity.UserRole;
import com.example.FinalProject.model.UserRoleModel;
import com.example.FinalProject.repository.UserRoleRepository;
import com.example.FinalProject.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRoleConverter userRoleConverter;

    @Override
    public UserRoleModel createUserRole(UserRoleModel userRoleModel) {
        userRoleRepository.save(userRoleConverter.convertFromModel(userRoleModel));
        return userRoleModel;
    }

    @Override
    public List<UserRoleModel> getAll() {
        List<UserRoleModel> userRoleModels = new ArrayList<>();
        for (UserRole userRole:userRoleRepository.findAll()) {
            userRoleModels.add(userRoleConverter.convertFromEntity(userRole));
        }
        return userRoleModels;
    }

    @Override
    public UserRoleModel getById(Long id) {
        if (id == null) return null;
        return userRoleConverter.convertFromEntity(userRoleRepository.getById(id));
    }

    @Override
    public UserRoleModel updateUserRole(UserRoleModel userRoleModel) {
        UserRoleModel userRoleModelUpdate = getById(userRoleConverter.convertFromModel(userRoleModel).getId());
        if (userRoleModel.getRoleName() != null) userRoleModelUpdate.setRoleName(userRoleModel.getRoleName());
        userRoleRepository.save(userRoleConverter.convertFromModel(userRoleModelUpdate));

        return userRoleModelUpdate;
    }

    @Override
    public UserRoleModel deleteById(Long id) {
        UserRoleModel userRoleModelDelete = getById(id);
        if (userRoleModelDelete != null)
            userRoleRepository.delete(userRoleConverter.convertFromModel(userRoleModelDelete));
        return userRoleModelDelete;
    }
}
