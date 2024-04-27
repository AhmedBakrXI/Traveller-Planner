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

    public List<LocalAttractionModel> getAllLocalAttraction(String city) {
        if (city == null) {
            return null;
        } else {
            return localAttractionRepository.findByCityName(city);
        }
    }
}
