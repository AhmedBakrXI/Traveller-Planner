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



    public List<AccomodationModel> getAllAccommodations(String destination)
    {
        return accommodationRepository.findByCityName(destination);
    }
}
