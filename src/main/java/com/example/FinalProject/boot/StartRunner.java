package com.example.FinalProject.boot;

import com.example.FinalProject.converter.UserConverter;
import com.example.FinalProject.converter.UserRoleConverter;
import com.example.FinalProject.entity.User;
import com.example.FinalProject.model.UserRoleModel;
import com.example.FinalProject.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunner implements CommandLineRunner {
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserRoleConverter userRoleConverter;

    @Override
    public void run(String... args) throws Exception {
        UserRoleModel roleAdmin = new UserRoleModel();
        roleAdmin.setRoleName("ROLE_ADMIN");
        userRoleService.createUserRole(roleAdmin);

        UserRoleModel roleStudent = new UserRoleModel();
        roleStudent.setRoleName("ROLE_STUDENT");
        userRoleService.createUserRole(roleStudent);

        UserRoleModel roleTeacher = new UserRoleModel();
        roleTeacher.setRoleName("ROLE_TEACHER");
        userRoleService.createUserRole(roleTeacher);

        User user = new User();
        user.setFullName("Bakai Berdibekov");
        user.setLogin("admin");
        user.setPassword("admin");
        user.setUserRole(userRoleConverter.convertFromModel(roleAdmin));
    }
}
