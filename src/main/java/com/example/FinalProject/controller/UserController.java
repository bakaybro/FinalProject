package com.example.FinalProject.controller;

import com.example.FinalProject.entity.User;
import com.example.FinalProject.model.UserModel;
import com.example.FinalProject.repository.UserRepository;
import com.example.FinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserModel getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel){
        return userService.createUser(userModel);
    }

    @PutMapping
    public UserModel updateUser(@RequestBody UserModel userModel){
        return userService.updateUser(userModel);
    }

    @DeleteMapping("/{id}")
    public UserModel deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
