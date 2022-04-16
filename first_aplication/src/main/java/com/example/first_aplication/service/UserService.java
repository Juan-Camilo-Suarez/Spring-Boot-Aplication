package com.example.first_aplication.service;


import com.example.first_aplication.entity.User;

public interface UserService {

    public Iterable<User> getAllUsers();

    public User createUser(User user) throws Exception;
    public User getUserById(Long id)throws Exception;
    public User updateUser(User user) throws Exception;

}
