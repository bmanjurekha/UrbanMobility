package com.example.urbanmobility.controller;

import com.example.urbanmobility.model.AuthDetails;
import com.example.urbanmobility.model.BookingDetails;
import com.example.urbanmobility.model.SupplierDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/*")
public class UserDetailsController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthService authService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody UserDetails user, @RequestHeader("authorization") String usertoken) {


            if(authService.isAuthenticatedUser(usertoken)){
                //Create Authorization
                AuthDetails authDetails = new AuthDetails();
                authDetails.setUsername(user.getUsername());
                authDetails.setPassword("supersecret");
                authDetails.setUsertoken(jwtService.generateToken(user.getUsername()));
                authService.save(authDetails);
                //Create Booking
                for (BookingDetails book : user.getBookings()) {
                    bookingService.saveBooking(book);
                }
                //Create User
                userService.saveUser(user);
                //Create Supplier -- if ROLE is Supplier
                if(user.getRole().toUpperCase()=="SUPPLIER") {
                    SupplierDetails supplierDetails = new SupplierDetails();
                    supplierDetails.setName(user.getUsername());
                    supplierService.saveSupplier(supplierDetails);
                }
                return ResponseEntity.ok("User Created");
            }
            else
                return ResponseEntity.ok("Unauthorized Token");

    }

    @PatchMapping("/update-user/{username}")
    public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody UserDetails user, @RequestHeader("authorization") String usertoken) {

      if(authService.isAuthenticatedUser(usertoken)){
                //Update User
                UserDetails userDetails =  GetUserDetails(username,user);
                userService.saveUser(userDetails);
                return ResponseEntity.ok("User Updated");
            }
            else
                return ResponseEntity.ok("Unauthorized Token");
    }

    @GetMapping("/get-user/{username}")
    public  ResponseEntity<UserDetails> getUser(@PathVariable String username, @RequestHeader("authorization") String usertoken)
    {
        if(authService.isAuthenticatedUser(usertoken)){
         return ResponseEntity.ok(userService.getUserDetails(username));
        }
        else
            return  ResponseEntity.ok(new UserDetails());
    }
    @GetMapping("/users")
    public  ResponseEntity<List<UserDetails>> getAllUsers(@RequestHeader("authorization") String usertoken)
    {
        if(authService.isAuthenticatedUser(usertoken)){
            return ResponseEntity.ok(userService.getAllUserDetails());
        }
        else
            return  ResponseEntity.ok(new ArrayList<UserDetails>());
    }
    private UserDetails GetUserDetails(String username,UserDetails user)
    {
        UserDetails userDetails = userService.getUserDetails(username);
        if(!(user.getAccountnumber().isBlank() || user.getAccountnumber().isEmpty()))
            userDetails.setAccountnumber(user.getAccountnumber());
        if(!(user.getEmail().isBlank() || user.getEmail().isEmpty()))
            userDetails.setEmail(user.getEmail());
        if(!(user.getPhone().isBlank() || user.getPhone().isEmpty()))
            userDetails.setPhone(user.getPhone());
        if(!(user.getSwishnumber().isBlank()|| user.getSwishnumber().isEmpty()))
            userDetails.setSwishnumber(user.getSwishnumber());

        return userDetails;
    }
}
