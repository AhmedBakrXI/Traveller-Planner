package com.software.assignment;

public enum AircraftType {
    AIRBUS_A320("Airbus A320"),
    BOEING_757("Boeing 757");

    private final String name;

    AircraftType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
