/**
 * This service class provides methods to interact with city data.
 */
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

    /**
     * Retrieves the city of the currently authenticated user.
     * @return A CityModel object representing the city of the currently authenticated user.
     */
    public CityModel getUserCity() {
        // Retrieve currently logged-in user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        // Retrieve user model based on the username
        UserModel userModel = userService.getUser(username);
        
        // Retrieve the city model by the user's city name
        return cityRepository.findByCityName(userModel.getCity());
    }

    /**
     * Retrieves all cities.
     * @return A list of CityModel objects representing all cities in the database.
     */
    public List<CityModel> getAllCities() {
        // Retrieve all cities from the repository
        return cityRepository.findAll();
    }
}
