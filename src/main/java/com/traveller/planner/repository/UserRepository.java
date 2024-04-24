package com.traveller.planner.repository;

import com.traveller.planner.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,String> {
}
