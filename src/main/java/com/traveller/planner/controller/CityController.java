package com.traveller.planner.controller;

import com.traveller.planner.model.*;
import com.traveller.planner.repository.CityRepository;
import com.traveller.planner.service.AccomodationService;
import com.traveller.planner.service.ActivityService;
import com.traveller.planner.service.FlightService;
import com.traveller.planner.service.LocalAttractionService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private LocalAttractionService localAttractionService;
    @Autowired
    private FlightService flightService;

    @Autowired
    private ActivityService activityService;
    @Autowired
    private AccomodationService accomodationService;
    @GetMapping("/city")
    public List<CityModel> getCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/usercity")
    public CityModel getUserCity() {
        return new CityModel("Gaza", 30.5, 35.6, "Earth Lords");
    }

    /************************* remove ya bakr *********************/
    @GetMapping("/test")
    public List<LocalAttractionModel> test()
    {
        return localAttractionService.getAllLocalAttraction("Alex");
    }
    @GetMapping("/flight")
    public List<FlightModel> testawy()
    {
        return flightService.getAllFlightsByDestinationAndCity("Alex","Cairo");
    }
    @GetMapping("/activity")
    public List<ActivityModel> activity()
    {
        return activityService.getAllActivities("Alex");
    }

    @GetMapping("/accomo")
    public List<AccomodationModel> accomo()
    {
        return accomodationService.getAllAccomodations("Cairo");
    }
    /*************************************************/

}
