package com.traveller.planner.repository;

import com.traveller.planner.model.AccomodationModel;
import com.traveller.planner.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccomodationRepository extends JpaRepository<AccomodationModel,String> {
    public List<AccomodationModel> findByCityName(String cityName);
}
