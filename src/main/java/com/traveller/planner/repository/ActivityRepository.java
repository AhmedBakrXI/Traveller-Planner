/**
 * This interface represents a repository for managing activities.
 * It extends JpaRepository for CRUD operations on ActivityModel entities.
 */
package com.traveller.planner.repository;

import com.traveller.planner.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityModel, String> {

    /**
     * Retrieves a list of activities based on the specified city name.
     *
     * @param cityName The name of the city for which activities are to be retrieved.
     * @return A list of ActivityModel objects representing activities in the specified city.
     */
    List<ActivityModel> findByCityName(String cityName);
}
