package com.example.urbanmobility.controller;

import com.example.urbanmobility.model.AuthDetails;
import com.example.urbanmobility.model.BookingDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.services.AuthService;
import com.example.urbanmobility.services.BookingService;
import com.example.urbanmobility.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/booking/*")
public class BookingDetailsController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/user-booking/{username}/{tripid}")
    public ResponseEntity<String> createUserBooking(@PathVariable String username, @PathVariable String tripid, @RequestHeader("authorization") String usertoken) {
        if (authService.isAuthenticatedUser(usertoken)) {
            //Create booking for the user
            UserDetails userDetails = userService.getUserDetails(username);
            if (userDetails != null) {
                ArrayList<BookingDetails> ltBooking = new ArrayList<>();
                BookingDetails bookingDetails = new BookingDetails();
                bookingDetails.setTripid(Integer.parseInt(tripid));
                ltBooking.add(bookingDetails);
                userDetails.setBookings(ltBooking);
                userService.saveUser(userDetails);
                return ResponseEntity.ok("Added Booking for the user");
            }
            return ResponseEntity.ok("Unable to find User");
        } else
            return ResponseEntity.ok("Unauthorized Token");
    }
    @PatchMapping("/user-booking/{username}/{oldtripid}/{newtripid}")
    public ResponseEntity<String> updateUserBooking(@PathVariable String username, @PathVariable String oldtripid, @PathVariable String newtripid, @RequestHeader("authorization") String usertoken) {
        if (authService.isAuthenticatedUser(usertoken)) {
            //Update User with booking
            UserDetails userDetails = userService.getUserDetails(username);
            if (userDetails != null) {
                for (BookingDetails bookingDetails : userDetails.getBookings()) {
                    if (bookingDetails.getTripid() == Integer.parseInt(oldtripid)) {
                        BookingDetails bookDtls = bookingService.getBookingByTripId(Integer.parseInt(oldtripid));
                        if (bookDtls != null) {
                            bookDtls.setTripid(Integer.parseInt(newtripid));
                            bookingService.saveBooking(bookDtls);
                            return ResponseEntity.ok("Booking updated for User");
                        }
                    }
                    return ResponseEntity.ok("Unable to find trip id for user");
                }
                return ResponseEntity.ok("Unable to find Booking for the user");
            }
            return ResponseEntity.ok("Unable to find User");

        } else
            return ResponseEntity.ok("Unauthorized Token");
    }

    @DeleteMapping("/user-booking/{username}/{tripid}")
    public  ResponseEntity<String> deleteUserBooking(@PathVariable String username, @PathVariable String tripid, @RequestHeader("authorization") String usertoken){

        if(authService.isAuthenticatedUser(usertoken)) {
            UserDetails userDetails = userService.getUserDetails(username);
            if (userDetails != null) {
                for (BookingDetails bookingDetails : userDetails.getBookings()) {
                    if(bookingDetails.getTripid() == Integer.parseInt(tripid)){
                        userDetails.getBookings().remove(bookingDetails);
                        userService.saveUser(userDetails);
                        return ResponseEntity.ok("Booking removed for the user");
                    }
                    else
                        return ResponseEntity.ok("Booking not found for the user");
                }
                return ResponseEntity.ok("Booking not found for the user");
            }
            else
                return  ResponseEntity.ok("Unable to find User");
        }
        else
            return  ResponseEntity.ok("Unauthorized Token");

    }
}





