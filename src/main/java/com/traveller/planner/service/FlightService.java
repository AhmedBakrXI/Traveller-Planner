/**
 * This service class provides methods to interact with flight data.
 */
package com.traveller.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.traveller.planner.model.FlightModel;
import com.traveller.planner.model.UserModel;
import com.traveller.planner.repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private UserService userService;

    /**
     * Retrieves all flights for a given destination and user's city.
     * @param destination The destination city for which flights are requested.
     * @return A list of FlightModel objects representing flights to the specified destination from the user's city.
     */
    public List<FlightModel> getAllFlightsByDestinationAndCity(String destination) {
        // Retrieve currently logged-in user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        // Retrieve user model based on the username
        UserModel userModel = userService.getUser(username);
        
        // Retrieve flights by city name and destination
        return flightRepository.findByCityNameAndDestination(userModel.getCity(), destination);
    }
}
