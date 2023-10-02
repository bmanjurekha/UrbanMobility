package com.example.urbanmobility.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalTime;


@Entity // enable jpa
@Data // enable getters n' setters
@NoArgsConstructor
public class RouteDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String placeofdeparture;
    private String placeofarrival;
    private String transportationtype;
    private Time departuretime;
    private Time arrivaltime;
    private double price;
    private double discount;

}