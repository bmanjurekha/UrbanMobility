package com.example.urbanmobility.controller;


import com.example.urbanmobility.model.AuthDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.services.AuthService;
import com.example.urbanmobility.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth/*")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtService jwtService;
    @GetMapping("/getToken/{username}/{password}")
    public ResponseEntity<String> getToken(@PathVariable String username,@PathVariable String password)
    {
        if(authService.authenticate(username,password)) {
            AuthDetails authDetails = new AuthDetails();
            authDetails.setUsername(username);
            authDetails.setPassword(password);
            return ResponseEntity.ok(jwtService.getToken(authDetails));
        }
        else
            return ResponseEntity.ok("Invalid User");
    }

}
