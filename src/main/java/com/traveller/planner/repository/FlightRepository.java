package com.traveller.planner.repository;

import com.traveller.planner.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<FlightModel,Integer> {
    public List<FlightModel> findByCityNameAndDestination(String cityName, String destination);

}
