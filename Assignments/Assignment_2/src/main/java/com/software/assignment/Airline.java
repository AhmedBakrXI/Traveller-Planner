package com.software.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airline {
    private final String name;
    private final Country country;
    private final List<Fleet> fleets;
    private final Set<Airline> landingArrangements;

    private final List<Aircraft> aircrafts;



    public Airline(String name, Country country) {
        this.name = name;
        this.country = country;
        fleets = new ArrayList<>();
        landingArrangements = new HashSet<>();
        aircrafts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public List<Fleet> getFleets() {
        return fleets;
    }

    public Country getCountry() {
        return country;
    }

    public Set<Airline> getLandingArrangements() {
        return landingArrangements;
    }

    public Airline addFleet(Aircraft aircraft, City fromCity, City toCity, int weekNumber) {
        fleets.add(new Fleet(aircraft, fromCity, toCity, weekNumber));
        return this;
    }

    public Airline addLandingArrangement(Airline airline) {
        landingArrangements.add(airline);
        return this;
    }

    public Airline addAircraft(Aircraft aircraft) {
        if (!aircrafts.contains(aircraft)) {
            aircrafts.add(aircraft);
        } else {
            System.out.println(aircraft + " already exists");
        }
        return this;
    }

    public Aircraft getAircraft(int id) throws Exception {
        for (var aircraft : aircrafts) {
            if (aircraft.getId() == id) {
                return aircraft;
            }
        }
        throw new Exception("Aircraft is not available");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Airline{");
        sb.append("name=").append(name);
        sb.append(", country=").append(country.getName());
        sb.append('}');
        return sb.toString();
    }

}
