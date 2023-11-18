package com.example.urbanmobility.integrationtest;
import com.example.urbanmobility.model.BookingDetails;
import com.example.urbanmobility.services.BookingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookingServiceIntegrationTest {
    @Autowired
    private BookingService bookingService;

    @BeforeAll
    static void addBooking(@Autowired BookingService bookingService) {
        bookingService.saveBooking(new BookingDetails(1,1));
        bookingService.saveBooking(new BookingDetails(2,2));
    }

    @Test
    void verifyThatReturnedListIsInitialized() {
        assertNotNull(bookingService.getAllBookings());
    }

    @Test
    void verifyInitializationOfEntriesAddedInBeforeAll() {
        assertEquals(2, bookingService.getAllBookings().size());
    }
}
