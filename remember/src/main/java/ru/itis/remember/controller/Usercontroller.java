package ru.itis.remember.controller;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.remember.models.User;
import ru.itis.remember.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class Usercontroller {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getusers")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user/{Id}", method = RequestMethod.GET)
    public Optional<User> findById(@PathVariable @NotNull Long Id) {
        return userRepository.findById(Id);

    }
}
