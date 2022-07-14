package ru.itis.remember.controller;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.itis.remember.models.User;
import ru.itis.remember.models.dto.UserDto;
import ru.itis.remember.repositories.UserRepository;
import ru.itis.remember.services.UserServiceImplement;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class Usercontroller {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImplement userServiceImplement;

    @GetMapping("/getusers")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user/{Id}", method = RequestMethod.GET)
    public Optional<User> findById(@PathVariable @NotNull Long Id) {
        return userServiceImplement.getUserById(Id);

    }

    @PostMapping("/add")
    public UserDto addUser(@RequestBody UserDto userDto){

        System.out.println(userDto.getName());
        return userDto;
    }

}
