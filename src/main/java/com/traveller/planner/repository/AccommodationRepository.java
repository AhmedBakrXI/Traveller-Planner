package com.traveller.planner.repository;

import com.traveller.planner.model.AccomodationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationRepository extends JpaRepository<AccomodationModel, String> {
    List<AccomodationModel> findByCityName(String cityName);
}
