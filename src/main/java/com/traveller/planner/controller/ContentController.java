package com.traveller.planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling content-related requests.
 */
@Controller
public class ContentController {

    /**
     * Handles requests to the home page.
     *
     * @return the name of the view template for the home page
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Handles requests to the login page.
     *
     * @return the name of the view template for the login page
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Handles requests to the register page.
     *
     * @return the name of the view template for the register page
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * Handles requests to the about page.
     *
     * @return the name of the view template for the about page
     */
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
