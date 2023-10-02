package com.example.urbanmobility.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity // enable jpa
@Data // enable getters n' setters
@NoArgsConstructor
public class SupplierDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
        @ManyToMany(fetch = FetchType.LAZY)
        private List<RouteDetails> routeDetails;

}

