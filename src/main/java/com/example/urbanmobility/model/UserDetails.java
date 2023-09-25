package com.example.urbanmobility.model;

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
public class UserDetails {

        private int id;
        private String userName;
        private String email;
        private String phone;
        private String role;
        private String swishNumber;
        private String accountNumber;
        private List<BookingDetails> bookings;

}
