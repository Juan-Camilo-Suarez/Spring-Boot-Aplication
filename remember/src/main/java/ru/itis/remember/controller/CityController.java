package ru.itis.remember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.remember.models.City;
import ru.itis.remember.repositories.CityRepository;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    CityRepository cityRepository;

    @GetMapping("/city")
    List<City> cityList(){
        return cityRepository.findAll();
    }
}
