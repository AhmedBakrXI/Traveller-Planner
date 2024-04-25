package com.traveller.planner.service;

import com.traveller.planner.model.ActivityModel;
import com.traveller.planner.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    public List<ActivityModel> getAllActivities(String cityName)
    {
        return activityRepository.findByCityName(cityName);
    }
}
