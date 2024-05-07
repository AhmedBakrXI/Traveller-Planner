package com.software.assignment;

import java.util.HashSet;
import java.util.Set;

public class City {
    private final String name;
    private final CityType type;
    private final Set<Airport> airports;

    public City(String name, CityType type) {
        this.name = name;
        this.type = type;
        airports = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public CityType getType() {
        return type;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    public Airport addAirport(String name) {
        Airport airport = null;
        if (type == CityType.SMALL_CITY && airports.size() == 1) {
            System.err.println("Can not add airport," 
                + "because City is small and has already an existing airport.");
        } else {
            airport = new Airport(name, this);
            airports.add(airport);
        }
        return airport;
    }

    public Airport getAirport(String name) {
        for (Airport airport : airports) {
            if (airport.getName().equalsIgnoreCase(name)) {
                return airport;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("City{");
        sb.append("name=").append(name);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }


}
