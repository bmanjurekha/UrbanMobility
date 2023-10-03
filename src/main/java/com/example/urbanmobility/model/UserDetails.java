package com.example.urbanmobility.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String username;
        private String email;
        private String phone;
        private String role;
        private String swishnumber;
        private String accountnumber;
        @ManyToMany(fetch = FetchType.LAZY)
        private List<BookingDetails> bookings;

}
