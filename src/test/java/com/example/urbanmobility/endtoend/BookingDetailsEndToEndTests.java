package com.example.urbanmobility.endtoend;
import com.example.urbanmobility.model.BookingDetails;
import com.example.urbanmobility.services.BookingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingDetailsEndToEndTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testEndToEndBookingDetailsWithoutAuth() throws Exception {
        mockMvc
                .perform(get("/booking/bookings"))
                .andExpect(status().is(400));
    }
    @Test
    void testEndToEndBookingDetailsWithAuth() throws Exception {
        mockMvc
                .perform(get("/booking/bookings")
                .header("authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InB1bmVldGgifQ.raKFp30meUbBJ9rOoYbUbnNv9oc2vUeQLGctdlblKGo"))
                .andExpect(status().is(200));
    }
    @Test
    void testEndToEndGetUserBooking() throws Exception {
        mockMvc
                .perform(get("/booking/user-booking/newUser")
                        .header("authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InB1bmVldGgifQ.raKFp30meUbBJ9rOoYbUbnNv9oc2vUeQLGctdlblKGo"))
                .andExpect(status().is(200));
    }
}
