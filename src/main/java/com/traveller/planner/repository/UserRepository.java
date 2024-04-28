package com.traveller.planner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traveller.planner.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {
    Optional<UserModel> findByUsername(String userName);
}
