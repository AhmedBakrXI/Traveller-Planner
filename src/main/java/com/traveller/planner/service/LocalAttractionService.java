/**
 * This service class provides methods to interact with local attractions data.
 */
package com.traveller.planner.service;

import com.traveller.planner.model.LocalAttractionModel;
import com.traveller.planner.repository.LocalAttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalAttractionService {

    @Autowired
    private LocalAttractionRepository localAttractionRepository;

    /**
     * Retrieves all local attractions for a given city.
     * @param city The name of the city for which attractions are requested.
     * @return A list of LocalAttractionModel objects representing attractions in the specified city.
     *         Returns null if the city is null.
     */
    public List<LocalAttractionModel> getAllLocalAttraction(String city) {
        if (city == null) {
            return null;
        } else {
            return localAttractionRepository.findByCityName(city);
        }
    }
}
