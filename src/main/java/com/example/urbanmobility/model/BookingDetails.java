package com.example.urbanmobility.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {
    private int id;
    private int tripId;
    private String userName;

}