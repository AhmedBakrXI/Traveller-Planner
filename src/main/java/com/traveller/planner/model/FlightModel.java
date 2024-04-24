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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String company;
    @Column
    private String time_start;
    @Column
    private String time_end;
    @Column
    private String destination;
    @Column
    private Double price;
    @Column
    private String logo;
    @Column
    private String city_name;
}
