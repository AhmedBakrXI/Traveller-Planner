package com.software.assignment;

import java.util.HashSet;
import java.util.Set;


public class Airport {
    private String name;
    private final City location;
    private final Set<AircraftType> aircraftTypes;


    public Airport(String name, City location){
        this.name = name;
        this.location = location;
        aircraftTypes = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public City getLocation() {
        return location;
    }

    public Set<AircraftType> getAircraftTypes() {
        return aircraftTypes;
    }

    public Airport addAircraftType(AircraftType aircraftType) {
        aircraftTypes.add(aircraftType);
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Airport{");
        sb.append("name=").append(name);
        sb.append(", location=").append(location);
        sb.append(", aircraftTypes=").append(aircraftTypes);
        sb.append('}');
        return sb.toString();
    }


}
