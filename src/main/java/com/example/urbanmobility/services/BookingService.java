package com.example.urbanmobility.services;
import com.example.urbanmobility.model.BookingDetails;
import com.example.urbanmobility.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    // ALL CRUD Operations for Booking
    public void saveBooking(BookingDetails bookingDetails) {
        bookingRepository.save(bookingDetails);
    }

    public void deleteBookingbytripid(long tripid){
        bookingRepository.deleteByTripid(tripid);
    }


    public BookingDetails getBookingByTripId(long tripid){
        return bookingRepository.findByTripid(tripid);
    }
}
