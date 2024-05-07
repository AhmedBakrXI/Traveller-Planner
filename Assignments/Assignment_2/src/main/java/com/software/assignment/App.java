package com.software.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) throws Exception {
        Country france = new Country("France");
        Country england = new Country("England");
        Country egypt = new Country("Egypt");

        france.addCity("Marseille", CityType.BIG_CITY)
                .addAirport("Marseille")
                .addAircraftType(AircraftType.BOEING_757);

        france.addCity("Paris", CityType.BIG_CITY)
                .addAirport("Paris International Airport")
                .addAircraftType(AircraftType.AIRBUS_A320)
                .addAircraftType(AircraftType.BOEING_757);

        france.getCity("Paris")
                .getAirport("Paris International Airport")
                .addAircraftType(AircraftType.AIRBUS_A320);

        england.addCity("London", CityType.BIG_CITY);

        england.getCity("London")
                .addAirport("London Gatwick Airport")
                .addAircraftType(AircraftType.AIRBUS_A320);

        egypt.addCity("Cairo", CityType.BIG_CITY)
                .addAirport("Cairo International Airport")
                .addAircraftType(AircraftType.AIRBUS_A320);

        var cairoLine = egypt.addAirline("Egypt Air")
                .addAircraft(new Aircraft(AircraftType.AIRBUS_A320));

        cairoLine
                .addFleet(cairoLine.getAircraft(1), egypt.getCity("Cairo"), france.getCity("Paris"), 1)
                .addFleet(cairoLine.getAircraft(1), egypt.getCity("Cairo"), england.getCity("London"), 1);


        egypt.addCity("Benha", CityType.SMALL_CITY)
                .addAirport("Benha Airport");


        // Test no 1: Success
        System.out.println("\n********************* Test 1 ****************************");
        var airport = france.getCity("Paris")
                .getAirport("Paris International Airport");
        System.out.println(getAircraftTypesAt(airport));

        // Test no 2: Success
        System.out.println("\n********************* Test 2 ****************************");
        List<Country> countries = List.of(france, england, egypt);
        System.out.println(getAirportsSupporting(countries, AircraftType.BOEING_757));

        // Test no 3: Success
        System.out.println("\n********************* Test 3 ****************************");
        System.out.println(france.getAirports());

        // Test no 4: Success
        System.out.println("\n********************* Test 4 ****************************");
        System.out.println(trackAircraft(countries, 1));
    }

    // Requirement no 1
    public static Set<AircraftType> getAircraftTypesAt(Airport airport) {
        return airport.getAircraftTypes();
    }

    // Requirement no 2
    public static List<Airport> getAirportsSupporting(List<Country> countries, AircraftType aircraftType) {
        List<Airport> airports = new ArrayList<>();

        for (Country country : countries) {
            for (City city : country.getCities()) {
                for (Airport airport : city.getAirports()) {
                    if (airport.getAircraftTypes().contains(aircraftType)) {
                        airports.add(airport);
                    }
                }
            }
        }

        return airports;
    }

    public static String trackAircraft(List<Country> countries, int id) throws Exception {
        Airline airline = getAirlineByAircraftId(countries, id);
        StringBuilder stringBuilder = new StringBuilder();

        assert airline != null;
        stringBuilder.append("Name: ")
                .append(airline.getName())
                .append("\n");
        for (Fleet fleet : airline.getFleets()) {
            if (fleet.getWeekNumber() == 1 && fleet.getAircraft().getId() == id) {
                stringBuilder.append(fleet)
                        .append("\n");
            }
        }

        return stringBuilder.toString();
    }

    private static Airline getAirlineByAircraftId(List<Country> countries, int aircraftId) throws Exception {
        for (Country country : countries) {
            for (Airline airline : country.getAirlines()) {
                if (airline.getAircraft(aircraftId) != null) {
                    return airline;
                }
            }
        }
        return null;
    }


}
