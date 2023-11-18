package com.example.urbanmobility.integrationtest;
import com.example.urbanmobility.model.BookingDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.services.BookingService;
import com.example.urbanmobility.services.SupplierService;
import com.example.urbanmobility.services.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceIntegrationTest {
    @Autowired
    private UserService userService;

    @BeforeAll
    static void addUsers(@Autowired UserService userService, @Autowired BookingService bookingService) {
        UserDetails uDtls = new UserDetails();
        List<BookingDetails> lBooking = new ArrayList<>();
        lBooking.add(new BookingDetails(1,1));
        lBooking.add(new BookingDetails(2,2));
        bookingService.saveBooking(new BookingDetails(1,1));
        bookingService.saveBooking(new BookingDetails(2,2));
        uDtls.setBookings(lBooking);
        uDtls.setEmail("example@example.com");
        uDtls.setPhone("123456789");
        uDtls.setSwishnumber("123456789");
        uDtls.setAccountnumber("74896328888");
        uDtls.setUsername("newUser1001");
        uDtls.setRole("User");
        userService.saveUser(uDtls);
    }
    @Test
    void verifyThatReturnedListIsInitialized() {
        assertNotNull(userService.getUserDetails("newUser1001"));
    }

    @Test
    void verifyInitializationOfEntriesAddedInBeforeAll() {
        assertEquals(1, userService.getAllUserDetails().size());
    }
}
