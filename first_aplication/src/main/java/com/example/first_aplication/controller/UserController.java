package com.example.first_aplication.controller;

import com.example.first_aplication.entity.User;
import com.example.first_aplication.repository.RoleRepository;
import com.example.first_aplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/userForm")
    public String getUserForm(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("roles",roleRepository.findAll());
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("listTab","active");
        return "user-form/user-view";
    }

    @PostMapping("/userForm")public String postUserForm(@Valid @ModelAttribute("userForm")User user, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("userForm", new User());
            model.addAttribute("formTab","active");
            System.out.println("err");
        }else{
            try {
                userService.createUser(user);
                model.addAttribute("userForm", new User());
                model.addAttribute("listTab","active");
            } catch (Exception e) {
                model.addAttribute("formError",e.getMessage());
                model.addAttribute("userForm", user);
                model.addAttribute("formTab","active");
            }

        }
        model.addAttribute("roles",roleRepository.findAll());
        model.addAttribute("userList", userService.getAllUsers());
        return "user-form/user-view";
    }


}