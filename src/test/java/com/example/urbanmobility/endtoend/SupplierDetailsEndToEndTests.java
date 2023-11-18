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
public class SupplierDetailsEndToEndTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void testEndToEndSupplierDetails() throws Exception {
        mockMvc
                .perform(get("/supplier/get-supplier")
                        .header("authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InB1bmVldGgifQ.raKFp30meUbBJ9rOoYbUbnNv9oc2vUeQLGctdlblKGo"))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"));
    }
}
