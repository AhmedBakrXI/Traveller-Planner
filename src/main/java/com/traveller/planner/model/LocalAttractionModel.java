/**
 * This class represents a local attraction entity in the application.
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
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "local_attractions")
public class LocalAttractionModel {

    /**
     * The name of the local attraction.
     */
    @Id
    private String name;

    /**
     * Information about the local attraction.
     */
    @Column
    private String info;

    /**
     * The URL or path to the image of the local attraction.
     */
    @Column
    private String image;

    /**
     * The name of the city where the local attraction is located.
     */
    @Column(name = "city_name")
    private String cityName;
}
