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

    /**
     * Retrieves all cities.
     *
     * @return a list of CityModel objects representing all cities
     */
    @GetMapping("/city")
    public List<CityModel> getCities() {
        return cityService.getAllCities();
    }

    /**
     * Retrieves the user's city.
     *
     * @return a CityModel object representing the user's city
     */
    @GetMapping("/usercity")
    public CityModel getUserCity() {
        return cityService.getUserCity();
    }

    /**
     * Retrieves all flights for a given destination.
     *
     * @param destination the destination for which flights are to be retrieved
     * @return a list of FlightModel objects representing flights for the destination
     */
    @PostMapping("/flights")
    public List<FlightModel> getFlights(@RequestBody String destination) {
        return flightService.getAllFlightsByDestinationAndCity(destination);
    }

    /**
     * Retrieves all activities for a given destination.
     *
     * @param destination the destination for which activities are to be retrieved
     * @return a list of ActivityModel objects representing activities for the destination
     */
    @PostMapping("/activities")
    public List<ActivityModel> getActivity(@RequestBody String destination) {
        return activityService.getAllActivities(destination);
    }

    /**
     * Retrieves all accommodations for a given destination.
     *
     * @param destination the destination for which accommodations are to be retrieved
     * @return a list of AccomodationModel objects representing accommodations for the destination
     */
    @PostMapping("/accommodations")
    public List<AccomodationModel> getAccommodations(@RequestBody String destination) {
        return accommodationService.getAllAccommodations(destination);
    }

    /**
     * Retrieves all local attractions for a given destination.
     *
     * @param destination the destination for which local attractions are to be retrieved
     * @return a list of LocalAttractionModel objects representing local attractions for the destination
     */
    @PostMapping("/local-attractions")
    public List<LocalAttractionModel> getLocalAttractions(@RequestBody String destination) {
        return localAttractionService.getAllLocalAttraction(destination);
    }

    /**
     * Retrieves fake cities for testing purposes.
     *
     * @param destination the destination (for testing purposes)
     * @return a list of CityModel objects representing fake cities
     */
    @PostMapping("/fake")
    public List<CityModel> getFakeCities(@RequestBody String destination) {
        System.out.println(destination);
        return List.of(new CityModel("aa", 22.5, 22.5, "info"),
                new CityModel("aaaaaa", 22.5, 22.5, "info"));
    }

}
