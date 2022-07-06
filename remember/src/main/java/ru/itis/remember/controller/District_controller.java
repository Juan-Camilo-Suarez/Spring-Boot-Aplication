package ru.itis.remember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.remember.models.District;
import ru.itis.remember.models.Republic;
import ru.itis.remember.repositories.DistrictRepository;

import java.util.List;

@RestController
public class District_controller {
    @Autowired
    DistrictRepository districtRepository;

    @GetMapping("/dis")
    List<District> getdistricts() {
        return districtRepository.findAll();
    }
}
