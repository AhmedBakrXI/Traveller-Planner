/**
 * The PlannerApplication class serves as the entry point for the Traveller Planner application.
 * It bootstraps the Spring Boot application by enabling auto-configuration and component scanning.
 */
package com.traveller.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlannerApplication {

    /**
     * The main method initializes the Spring Boot application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(PlannerApplication.class, args);
    }
}
