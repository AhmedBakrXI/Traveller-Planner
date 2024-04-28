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

    public List<ActivityModel> getAllActivities(String destination) {
        return activityRepository.findByCityName(destination);
    }
}
