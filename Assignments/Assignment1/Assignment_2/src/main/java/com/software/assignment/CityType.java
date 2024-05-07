package com.software.assignment;

public enum CityType {
    BIG_CITY("Big City"),
    SMALL_CITY("Small City");


    private final String name;

    CityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
