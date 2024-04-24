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
    @Id
    private String name;
    @Column
    private Double price;
    @Column
    private String info;
    @Column
    private String image;
    @Column(name = "city_name") // Use the correct field name in the database
    private String cityName; // Use camel case for the variable name
}
