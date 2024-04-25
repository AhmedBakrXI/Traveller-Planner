package com.traveller.planner.service;

import com.traveller.planner.model.CityModel;
import com.traveller.planner.model.UserModel;
import com.traveller.planner.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserService userService;

    public CityModel getUserCity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserModel userModel = userService.getUser(username);
        return cityRepository.findByCityName(userModel.getCity());
    }

    public List<CityModel> getAllCities() {
        return cityRepository.findAll();
    }
}
