package com.example.urbanmobility.controller;

import com.example.urbanmobility.model.RouteDetails;
import com.example.urbanmobility.model.SupplierDetails;
import com.example.urbanmobility.services.AuthService;
import com.example.urbanmobility.services.RouteService;
import com.example.urbanmobility.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route/*")
public class RouteDetailsController {
    @Autowired
    private AuthService authService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create-route")
    public ResponseEntity<String> createRoute(@RequestBody RouteDetails route, @RequestHeader("authorization") String usertoken) {
        if (authService.isAuthenticatedUser(usertoken)) {
            routeService.saveTrip(route);
            return ResponseEntity.ok("Route Details Created");
        } else
            return  ResponseEntity.ok("Unauthorized Token");
    }
}

