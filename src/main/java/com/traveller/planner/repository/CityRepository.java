package com.traveller.planner.repository;

import com.traveller.planner.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityModel,String> {
}
