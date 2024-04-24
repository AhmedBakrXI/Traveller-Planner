package com.traveller.planner.service;

import com.traveller.planner.model.UserModel;
import com.traveller.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public void registerUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserModel checkUser(String userName, String password) {
        if (userName == null || password == null) {
            return null;
        } else {
            UserModel user = userRepository.findByUsername(userName).orElse(null);
            if (user == null) {
                return null;
            } else {
                if (user.getPassword().equals(password)) {
                    return user;
                } else {
                    return null;
                }
            }
        }
    }
}
