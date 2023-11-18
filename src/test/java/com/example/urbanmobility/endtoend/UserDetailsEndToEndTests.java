package com.example.urbanmobility.endtoend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserDetailsEndToEndTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testEndToEndUserDetails() throws Exception {
        mockMvc
                .perform(get("/user/get-user/newUser")
                        .header("authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InB1bmVldGgifQ.raKFp30meUbBJ9rOoYbUbnNv9oc2vUeQLGctdlblKGo"))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"));
    }
    @Test
    void testEndToEndAllUserDetails() throws Exception {
        mockMvc
                .perform(get("/user/users")
                        .header("authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InB1bmVldGgifQ.raKFp30meUbBJ9rOoYbUbnNv9oc2vUeQLGctdlblKGo"))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"));
    }
}
