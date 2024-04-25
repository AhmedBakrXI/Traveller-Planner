package com.traveller.planner.repository;

import com.traveller.planner.model.LocalAttractionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalAttractionRepository extends JpaRepository<LocalAttractionModel,String> {
    public List<LocalAttractionModel> findByCityName(String cityName);
}
