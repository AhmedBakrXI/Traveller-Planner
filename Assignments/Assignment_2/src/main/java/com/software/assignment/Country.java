package com.software.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Country {
    private final String name;
    private final Set<City> cities;
    private final Set<Airline> airlines;

    public Country(String name) {
        this.name = name;
        this.cities = new HashSet<>();
        this.airlines = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Airline> getAirlines() {
        return airlines;
    }


    public List<Airport> getAirports() {
        var airports = new ArrayList<Airport>();

        for (var city : cities) {
            airports.addAll(city.getAirports());
        }

        return airports;
    }

    
    public City addCity(String name, CityType type) {
        cities.add(new City(name, type));
        for (var city : cities) {
            if (city.getName().equalsIgnoreCase(name)) {
                return city;
            }
        }
        return null;
    }

    public City getCity(String name) {
        for (var city : cities) {
            if (city.getName().equalsIgnoreCase(name)) {
                return city;
            }
        }
        return null;
    }

    
    public Set<City> getCities() {
        return cities;
    }

    public Airline addAirline(String name) {
        var airline = new Airline(name, this);
        airlines.add(airline);
        return airline;
    }

    public Airline getAirline(String name) {
        for (var airline : airlines) {
            if (airline.getName().equalsIgnoreCase(name)) {
                return airline;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Country{");
        sb.append("name=").append(name);
        sb.append(", cities=").append(cities);
        sb.append(", airlines=").append(airlines);
        sb.append('}');
        return sb.toString();
    }
}
