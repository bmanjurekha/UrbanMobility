package com.example.urbanmobility.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;
@Data
@Builder
public class SupplierDetails {
        private int id;
        private String name;
        private List<TripDetails> trips;
}
