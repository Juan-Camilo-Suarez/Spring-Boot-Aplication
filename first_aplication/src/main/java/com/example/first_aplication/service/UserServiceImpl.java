package com.example.first_aplication.service;

import com.example.first_aplication.entity.User;
import com.example.first_aplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    public Iterable getAllUsers(){
        return repository.findAll();
    }



    private boolean checkUsernameAvailable(User user) throws Exception {
        Optional userFound = repository.findByUsername(user.getUsername());
        if (userFound.isPresent()) {
            throw new Exception("Username no disponible");
        }
        return true;
    }

    private boolean checkPasswordValid(User user) throws Exception {
        if ( !user.getPassword().equals(user.getConfirmPassword())) {
            throw new Exception("Password y Confirm Password no son iguales");
        }
        return true;
    }
    @Override
    public User createUser(User user) throws Exception {
        if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
            user = repository.save(user);
        }
        return user;
    }

    @Override
    public User getUserById(Long id) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new Exception("User does not exist"));
        return user;
    }

    @Override
    public User updateUser(User fromUser) throws Exception {
        User toUser = getUserById(fromUser.getId());
        mapUser(fromUser, toUser);
        return repository.save(toUser);
    }

    protected void mapUser(User from,User to) {
        to.setUsername(from.getUsername());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());
        to.setRoles(from.getRoles());
    }
    @Override
    public void deleteUser(Long id) throws Exception {
        User user = repository.findById(id)
                .orElseThrow(() -> new Exception("UsernotFound in deleteUser -"+this.getClass().getName()));

        repository.delete(user);
    }
}