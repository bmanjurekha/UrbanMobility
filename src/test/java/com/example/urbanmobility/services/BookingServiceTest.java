package com.example.urbanmobility.services;


import com.example.urbanmobility.model.BookingDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.repository.BookingRepository;
import com.example.urbanmobility.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    BookingRepository bookingRepository;


    @InjectMocks
    BookingService bookingService = new BookingService();

    @Test
    void verifyGetUserBooking(){
        var bookingDetails = BookingDetails
                .builder()
                .id(1)
                .tripid(1001)
                .build();


        when(bookingRepository.findByTripid(1001L)).thenReturn(bookingDetails);
        bookingService.getBookingByTripId(1001L);
        verify(bookingRepository).findByTripid(1001L);
    }

}
