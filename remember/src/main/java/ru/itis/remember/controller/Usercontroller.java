package ru.itis.remember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.remember.models.User;
import ru.itis.remember.repositories.UserRepository;

import java.util.List;

@RestController
public class Usercontroller {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getusers")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
