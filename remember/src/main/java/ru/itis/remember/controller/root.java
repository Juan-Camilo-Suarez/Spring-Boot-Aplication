package ru.itis.remember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class root {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
