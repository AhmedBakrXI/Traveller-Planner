/**
 * This interface represents a repository for managing local attractions.
 * It extends JpaRepository for CRUD operations on LocalAttractionModel entities.
 */
package com.traveller.planner.repository;

import com.traveller.planner.model.LocalAttractionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalAttractionRepository extends JpaRepository<LocalAttractionModel, String> {

    /**
     * Retrieves a list of local attractions based on the specified city name.
     *
     * @param cityName The name of the city for which local attractions are to be retrieved.
     * @return A list of LocalAttractionModel objects representing local attractions in the specified city.
     */
    List<LocalAttractionModel> findByCityName(String cityName);
}
