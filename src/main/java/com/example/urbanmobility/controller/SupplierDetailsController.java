package com.example.urbanmobility.controller;

import com.example.urbanmobility.model.RouteDetails;
import com.example.urbanmobility.model.SupplierDetails;
import com.example.urbanmobility.services.AuthService;
import com.example.urbanmobility.services.RouteService;
import com.example.urbanmobility.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/supplier/*")
public class SupplierDetailsController {
    @Autowired
    private AuthService authService;
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create-supplier")
    public ResponseEntity<String> createSupplier(@RequestBody SupplierDetails supplier, @RequestHeader("authorization") String usertoken) {
        if (authService.isAuthenticatedUser(usertoken)) {
            supplierService.saveSupplier(supplier);
            return ResponseEntity.ok("Supplier Details Created");
        } else
            return  ResponseEntity.ok("Unauthorized Token");
    }
    @GetMapping("/get-supplier")
    public ResponseEntity<List<SupplierDetails>> getSupplier(@RequestHeader("authorization") String usertoken) {
        if (authService.isAuthenticatedUser(usertoken)) {
            return ResponseEntity.ok(supplierService.getAllSupplier());
        } else
            return  ResponseEntity.ok(new ArrayList<SupplierDetails>());
    }

}
