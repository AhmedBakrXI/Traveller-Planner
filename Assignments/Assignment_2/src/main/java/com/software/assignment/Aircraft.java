package com.software.assignment;

public class Aircraft {
    private static int noOfAircrafts;
    private final int id;
    private final AircraftType type;

    public Aircraft(AircraftType type) {
        this.type = type;
        this.id = ++noOfAircrafts;
    }

    public int getId() {
        return id;
    }

    public AircraftType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aircraft{");
        sb.append("id=").append(id);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
