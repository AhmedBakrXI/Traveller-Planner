package com.traveller.planner.repository;

import com.traveller.planner.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityModel, String> {
    List<ActivityModel> findByCityName(String cityName);
}
