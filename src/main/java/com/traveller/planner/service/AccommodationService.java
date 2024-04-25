package com.traveller.planner.service;

import com.traveller.planner.model.AccomodationModel;
import com.traveller.planner.model.UserModel;
import com.traveller.planner.repository.AccomodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationService {
    @Autowired
    private AccomodationRepository accommodationRepository;



    public List<AccomodationModel> getAllAccommodations(String destination)
    {
        return accommodationRepository.findByCityName(destination);
    }
}
