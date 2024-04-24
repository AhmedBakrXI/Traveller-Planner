package com.traveller.planner.controller;

import com.traveller.planner.model.CityModel;
import com.traveller.planner.model.UserModel;
import com.traveller.planner.repository.CityRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/city")
    public List<CityModel> getCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/usercity")
    public CityModel getUserCity() {
        return new CityModel("Gaza", 30.5, 35.6, "Earth Lords");
    }
}
