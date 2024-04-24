package com.traveller.planner.service;

import com.traveller.planner.model.AccomodationModel;
import com.traveller.planner.repository.AccomodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationService {
    @Autowired
    private AccomodationRepository accomodationRepository;

    public List<AccomodationModel> getAllAccomodations(String cityName)
    {
        return accomodationRepository.findByCityName(cityName);
    }
}
