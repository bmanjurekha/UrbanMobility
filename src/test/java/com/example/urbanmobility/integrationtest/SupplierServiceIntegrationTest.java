package com.example.urbanmobility.integrationtest;
import com.example.urbanmobility.model.RouteDetails;
import com.example.urbanmobility.model.SupplierDetails;
import com.example.urbanmobility.services.SupplierService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class SupplierServiceIntegrationTest {
    @Autowired
    private SupplierService supplierService;

    @BeforeAll
    static void addSupplier(@Autowired SupplierService supplierService) {
        SupplierDetails sDtls = new SupplierDetails();
        RouteDetails rDtls = new RouteDetails();
        rDtls.setTransportationtype("Public Transport");
        rDtls.setArrivaltime(Time.valueOf("16:00:00"));
        rDtls.setDeparturetime(Time.valueOf("16:30:00"));
        rDtls.setDiscount(1);
        rDtls.setPrice(60);
        rDtls.setPlaceofarrival("Nordstan");
        rDtls.setPlaceofarrival("Folkvisegatan 22");
        List<RouteDetails> lrDtls = new ArrayList<>();
        lrDtls.add(rDtls);
        sDtls.setName("Vastrafik");
        sDtls.setRouteDetails(lrDtls);
        supplierService.saveSupplier(sDtls);
    }
    @Test
    void verifyThatReturnedListIsInitialized() {
        assertNotNull(supplierService.getSupplierByname("Vastrafik"));
    }

    @Test
    void verifyInitializationOfEntriesAddedInBeforeAll() {
        assertEquals(1, supplierService.getAllSupplier().size());
    }

}
