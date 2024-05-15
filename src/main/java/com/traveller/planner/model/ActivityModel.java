/**
 * This class represents an activity entity in the application.
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
@Table(name = "activity")
@Entity
public class ActivityModel {

    /**
     * The name of the activity.
     */
    @Id
    private String name;

    /**
     * The price of the activity.
     */
    @Column
    private Double price;

    /**
     * Additional information about the activity.
     */
    @Column
    private String info;

    /**
     * The URL or path to the image of the activity.
     */
    @Column
    private String image;

    /**
     * The name of the city where the activity is located.
     */
    @Column(name = "city_name")
    private String cityName;
}
