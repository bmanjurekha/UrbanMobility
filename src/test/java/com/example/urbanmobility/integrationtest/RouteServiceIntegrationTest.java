package com.example.urbanmobility.integrationtest;
import com.example.urbanmobility.model.RouteDetails;
import com.example.urbanmobility.services.RouteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class RouteServiceIntegrationTest {
    @Autowired
    private RouteService routeService;

    @BeforeAll
    static void addRoutes(@Autowired RouteService routeService) {
        RouteDetails rDtls = new RouteDetails();
        rDtls.setTransportationtype("Public Transport");
        rDtls.setArrivaltime(Time.valueOf("16:00:00"));
        rDtls.setDeparturetime(Time.valueOf("16:30:00"));
        rDtls.setDiscount(1);
        rDtls.setPrice(60);
        rDtls.setPlaceofarrival("Nordstan");
        rDtls.setPlaceofarrival("Folkvisegatan 22");

        routeService.saveTrip(rDtls);
    }

    @Test
    void verifyThatReturnedListIsInitialized() {
        assertNotNull(routeService.getAllRoute());
    }

    @Test
    void verifyInitializationOfEntriesAddedInBeforeAll() {
        assertEquals(1, routeService.getAllRoute().size());
    }
}
