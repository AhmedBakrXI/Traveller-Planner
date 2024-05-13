/**
 * The UserService class provides methods for user registration, retrieval, and authentication.
 * It interacts with the UserRepository to perform CRUD operations on User entities.
 */
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
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user by encoding the password using the password encoder
     * and saving the user details to the database.
     *
     * @param user The UserModel object representing the user to be registered.
     */
    public void registerUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    /**
     * Retrieves a user by their username.
     *
     * @param userName The username of the user to be retrieved.
     * @return The UserModel object representing the user, or null if not found.
     */
    public UserModel getUser(String userName) {
        return userRepository.findByUsername(userName).orElse(null);
    }

    /**
     * Checks if the provided username and password match any existing user in the database.
     *
     * @param userName The username of the user to be checked.
     * @param password The password of the user to be checked.
     * @return The UserModel object representing the authenticated user, or null if authentication fails.
     */
    public UserModel checkUser(String userName, String password) {
        if (userName == null || password == null) {
            return null;
        } else {
            UserModel user = userRepository.findByUsername(userName).orElse(null);
            if (user == null) {
                return null;
            } else {
                // Compare the provided password with the encoded password stored in the database
                if (passwordEncoder.matches(password, user.getPassword())) {
                    return user;
                } else {
                    return null;
                }
            }
        }
    }
}
