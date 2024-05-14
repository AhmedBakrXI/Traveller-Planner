package com.traveller.planner.controller;

import com.traveller.planner.model.UserModel;
import com.traveller.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller class for user registration functionality.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    /**
     * Handles POST requests to create a new user.
     *
     * @param user the UserModel object containing user information from the registration form
     * @return a redirection to the login page if registration is successful, otherwise a redirection to the registration page with an error message
     */
    @PostMapping("/register")
    public String createUser(@ModelAttribute UserModel user) {
        if (userService.getUser(user.getUsername()) == null) {
            userService.registerUser(user);
            return "redirect:/login";
        } else {
            return "redirect:/register?error";
        }
    }
}
