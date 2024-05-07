package com.software.assignment;

public class Fleet {
    private int weekNumber;
    private final City fromCity;
    private final City toCity;
    private final Aircraft aircraft;

    public Fleet(Aircraft aircraft, City fromCity, City toCity, int weekNumber) {
        this.aircraft = aircraft;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.weekNumber = weekNumber;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void updateWeekNumbers(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fleet{");
        sb.append("weekNumber=").append(weekNumber);
        sb.append(", fromCity=").append(fromCity);
        sb.append(", toCity=").append(toCity);
        sb.append(", aircraft=").append(aircraft);
        sb.append('}');
        return sb.toString();
    }

}
