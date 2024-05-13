/**
 * This service class provides methods to interact with accommodation data.
 */
package com.traveller.planner.service;

import com.traveller.planner.model.AccomodationModel;
import com.traveller.planner.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    /**
     * Retrieves all accommodations for a given destination.
     * @param destination The destination city for which accommodations are requested.
     * @return A list of AccomodationModel objects representing accommodations in the specified destination.
     */
    public List<AccomodationModel> getAllAccommodations(String destination) {
        // Retrieve accommodations by destination city name
        return accommodationRepository.findByCityName(destination);
    }
}
