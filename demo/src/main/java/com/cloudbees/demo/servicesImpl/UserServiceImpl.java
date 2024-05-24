package com.cloudbees.demo.servicesImpl;

import com.cloudbees.demo.entity.User;
import com.cloudbees.demo.repositories.UserRepository;
import com.cloudbees.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public void createUser(User user){
        userRepository.save(user);
    }
}
