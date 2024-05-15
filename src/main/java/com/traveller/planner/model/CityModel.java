/**
 * This class represents a city entity in the application.
 */
package com.traveller.planner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
@Entity
public class CityModel {

    /**
     * The name of the city.
     */
    @Id
    private String cityName;

    /**
     * The latitude coordinate of the city.
     */
    @Column
    private Double lat;

    /**
     * The longitude coordinate of the city.
     */
    @Column(name = "long")
    private Double cityLong;

    /**
     * Additional information about the city.
     */
    @Column
    private String info;
}
