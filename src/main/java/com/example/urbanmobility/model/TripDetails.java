package com.example.urbanmobility.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder

public class TripDetails {
    private int id;
    private String placeOfDeparture;
    private String placeOfArrival;
    private String transportationType;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime departureTime;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime arrivalTime;
    private double price;
    private double discount;

    @ElementCollection
    private List<String> bookedPassengers = new ArrayList<>();
    private SupplierDetails supplier;



}