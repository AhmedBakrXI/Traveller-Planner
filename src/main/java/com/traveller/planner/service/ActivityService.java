/**
 * This service class provides methods to interact with activity data.
 */
package com.traveller.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traveller.planner.model.ActivityModel;
import com.traveller.planner.repository.ActivityRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    /**
     * Retrieves all activities for a given destination.
     * @param destination The destination city for which activities are requested.
     * @return A list of ActivityModel objects representing activities in the specified destination.
     */
    public List<ActivityModel> getAllActivities(String destination) {
        // Retrieve activities by destination city name
        return activityRepository.findByCityName(destination);
    }
}
