package com.traveller.planner.repository;

import com.traveller.planner.model.ActivityModel;
import com.traveller.planner.model.LocalAttractionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityModel,String> {
    public List<ActivityModel> findByCityName(String cityName);
}
