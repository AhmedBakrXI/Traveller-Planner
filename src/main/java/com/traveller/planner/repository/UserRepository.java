package com.traveller.planner.repository;

import com.traveller.planner.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,String> {
    public Optional<UserModel> findByUsername(String userName);
}
