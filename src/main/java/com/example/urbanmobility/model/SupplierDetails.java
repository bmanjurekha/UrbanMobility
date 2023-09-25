package com.example.urbanmobility.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SupplierDetails {


        private int id;
        private String name;
        private List<TripDetails> trips;
}
