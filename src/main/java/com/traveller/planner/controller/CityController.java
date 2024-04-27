package com.traveller.planner.controller;

import com.traveller.planner.model.*;
import com.traveller.planner.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Autowired
    private LocalAttractionService localAttractionService;
    @Autowired
    private FlightService flightService;

    @Autowired
    private ActivityService activityService;
    @Autowired
    private AccommodationService accommodationService;

    @GetMapping("/city")
    public List<CityModel> getCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/usercity")
    public CityModel getUserCity() {
        return cityService.getUserCity();
    }

    @PostMapping("/flights")
    public List<FlightModel> getFlights(@RequestBody String destination) {
        return flightService.getAllFlightsByDestinationAndCity(destination);
    }

    @PostMapping("/activities")
    public List<ActivityModel> getActivity(@RequestBody String destination) {
        return activityService.getAllActivities(destination);
    }

    @PostMapping("/accommodations")
    public List<AccomodationModel> getAccommodations(@RequestBody String destination) {
        return accommodationService.getAllAccommodations(destination);
    }

    @PostMapping("/local-attractions")
    public List<LocalAttractionModel> getLocalAttractions(@RequestBody String destination) {
        return localAttractionService.getAllLocalAttraction(destination);
    }

    @PostMapping("/fake")
    public List<CityModel> getFakeCities(@RequestBody String destination) {
        System.out.println(destination);
        return List.of(new CityModel("aa", 22.5, 22.5, "info"),
                new CityModel("aaaaaa", 22.5, 22.5, "info"));
    }

}
