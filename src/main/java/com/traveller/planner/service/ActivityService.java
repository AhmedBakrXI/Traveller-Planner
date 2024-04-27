package com.traveller.planner.service;

import com.traveller.planner.model.ActivityModel;
import com.traveller.planner.model.UserModel;
import com.traveller.planner.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private UserService userService;

    @Autowired
    private ActivityRepository activityRepository;

    public List<ActivityModel> getAllActivities(String destination) {
        return activityRepository.findByCityName(destination);
    }
}
