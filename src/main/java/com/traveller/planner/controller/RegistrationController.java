package com.traveller.planner.controller;

import com.traveller.planner.model.UserModel;
import com.traveller.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String createUser(@ModelAttribute UserModel user) {
        userService.registerUser(user);
        return "redirect:/login";
    }
}
