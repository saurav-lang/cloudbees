package com.cloudbees.demo.controllers;


import com.cloudbees.demo.entity.User;
import com.cloudbees.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping(value = "/create")
    public ResponseEntity createUser(@RequestBody User user){
        userService.createUser(user);
        return  ResponseEntity.status(HttpStatus.OK).body("User created successfully");
    }
}
