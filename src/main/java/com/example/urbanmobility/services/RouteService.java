package com.example.urbanmobility.services;

import com.example.urbanmobility.model.RouteDetails;
import com.example.urbanmobility.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RouteService {
    @Autowired
    RouteRepository routeRepository;
    // ALL CRUD Operations for Trip
    public void saveTrip(RouteDetails tripDetails) {
        routeRepository.save(tripDetails);
    }
    public void deleteTripById(long tripid){
        routeRepository.deleteById(tripid);
    }
    public RouteDetails getTripbyId(long tripid){
        return routeRepository.findById(tripid);
    }
}
