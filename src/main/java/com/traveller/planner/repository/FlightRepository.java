package com.traveller.planner.repository;

import com.traveller.planner.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightModel,Integer> {
}
