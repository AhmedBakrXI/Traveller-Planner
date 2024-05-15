/**
 * This class represents an accommodation entity in the application.
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
@Table(name = "accomodations")
@Entity
public class AccomodationModel {

    /**
     * The name of the hotel or accommodation.
     */
    @Id
    private String hotelName;

    /**
     * The star rating of the accommodation.
     */
    @Column
    private Integer stars;

    /**
     * The price of the accommodation.
     */
    @Column
    private Double price;

    /**
     * The URL or path to the image of the accommodation.
     */
    @Column
    private String image;

    /**
     * The name of the city where the accommodation is located.
     */
    @Column(name = "city_name")
    private String cityName;
}
