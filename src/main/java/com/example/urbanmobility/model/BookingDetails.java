package com.example.urbanmobility.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class BookingDetails {
    private int id;
    private int tripId;
    private String userName;

}