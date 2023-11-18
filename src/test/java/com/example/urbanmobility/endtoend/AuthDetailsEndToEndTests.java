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
public class AuthDetailsEndToEndTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testEndToEndAuthDetails() throws Exception {
        mockMvc
                .perform(get("/auth/getToken/newUser/supersecret"))
                .andExpect(status().is(200));
    }
}
