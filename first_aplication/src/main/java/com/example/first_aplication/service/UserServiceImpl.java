package com.example.first_aplication.service;

import com.example.first_aplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public Iterable getAllUsers(){
        return userRepository.findAll();
    }

}