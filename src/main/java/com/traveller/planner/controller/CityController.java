package com.traveller.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traveller.planner.model.AccomodationModel;
import com.traveller.planner.model.ActivityModel;
import com.traveller.planner.model.CityModel;
import com.traveller.planner.model.FlightModel;
import com.traveller.planner.model.LocalAttractionModel;
import com.traveller.planner.service.AccommodationService;
import com.traveller.planner.service.ActivityService;
import com.traveller.planner.service.CityService;
import com.traveller.planner.service.FlightService;
import com.traveller.planner.service.LocalAttractionService;

@RestController
@RequestMapping("/api")
public class CityController {


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
