/**
 * This interface represents a repository for managing cities.
 * It extends JpaRepository for CRUD operations on CityModel entities.
 */
package com.traveller.planner.repository;

import com.traveller.planner.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityModel, String> {

    /**
     * Retrieves a city based on the specified city name.
     *
     * @param cityName The name of the city to retrieve.
     * @return The CityModel object representing the city with the specified name, or null if not found.
     */
    CityModel findByCityName(String cityName);
}
