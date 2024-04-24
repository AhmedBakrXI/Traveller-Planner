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
    @Id
    private String city_name;
    @Column
    private Double lat;
    @Column(name = "long")
    private Double city_long;
    @Column
    private String info;

}
