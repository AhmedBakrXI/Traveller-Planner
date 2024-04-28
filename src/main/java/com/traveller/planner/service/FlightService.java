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

    public List<FlightModel> getAllFlightsByDestinationAndCity(String destination) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserModel userModel = userService.getUser(username);
        return flightRepository.findByCityNameAndDestination(userModel.getCity(), destination);
    }
}
