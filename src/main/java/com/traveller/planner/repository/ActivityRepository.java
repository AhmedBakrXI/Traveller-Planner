package com.traveller.planner.repository;

import com.traveller.planner.model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityModel,String> {
}
