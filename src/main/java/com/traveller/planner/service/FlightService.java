package com.traveller.planner.service;

import com.traveller.planner.model.FlightModel;
import com.traveller.planner.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    public List<FlightModel> getAllFlightsByDestinationAndCity(String cityName,String destination)
    {
        return flightRepository.findByCityNameAndDestination(cityName,destination);
    }
}
