/**
 * This interface represents a repository for managing accommodations.
 * It extends JpaRepository for CRUD operations on AccommodationModel entities.
 */
package com.traveller.planner.repository;

import com.traveller.planner.model.AccomodationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<AccomodationModel, String> {

    /**
     * Retrieves a list of accommodations based on the specified city name.
     *
     * @param cityName The name of the city for which accommodations are to be retrieved.
     * @return A list of AccommodationModel objects representing accommodations in the specified city.
     */
    List<AccomodationModel> findByCityName(String cityName);
}
