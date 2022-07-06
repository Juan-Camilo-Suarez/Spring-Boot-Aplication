package ru.itis.remember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.remember.models.Republic;
import ru.itis.remember.repositories.RepublicRepository;

import java.util.List;

@RestController
public class RepublicController {
    @Autowired
    RepublicRepository republicRepository;

    @GetMapping("/re")
    List<Republic> getRepublic(){
       return republicRepository.findAll();
    }

}
