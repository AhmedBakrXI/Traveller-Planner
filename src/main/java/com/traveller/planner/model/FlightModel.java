/**
 * This class represents a flight entity in the application.
 */
package com.traveller.planner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
@Entity
public class FlightModel {

    /**
     * The unique identifier (ID) of the flight.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The company operating the flight.
     */
    @Column
    private String company;

    /**
     * The departure time of the flight.
     */
    @Column(name = "time_start")
    private String timeStart;

    /**
     * The arrival time of the flight.
     */
    @Column(name = "time_end")
    private String timeEnd;

    /**
     * The destination of the flight.
     */
    @Column
    private String destination;

    /**
     * The price of the flight.
     */
    @Column
    private Double price;

    /**
     * The URL or path to the logo of the airline company.
     */
    @Column
    private String logo;

    /**
     * The name of the city where the flight departs from.
     */
    @Column(name = "city_name")
    private String cityName;
}
