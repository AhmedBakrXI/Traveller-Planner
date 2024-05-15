/**
 * This interface represents a repository for managing flights.
 * It extends JpaRepository for CRUD operations on FlightModel entities.
 */
package com.traveller.planner.repository;

import com.traveller.planner.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<FlightModel, Integer> {

    /**
     * Retrieves a list of flights based on the specified departure city and destination.
     *
     * @param cityName    The name of the departure city.
     * @param destination The destination city.
     * @return A list of FlightModel objects representing flights from the specified city to the destination.
     */
    List<FlightModel> findByCityNameAndDestination(String cityName, String destination);
}
