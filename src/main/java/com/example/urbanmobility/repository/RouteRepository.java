package com.example.urbanmobility.repository;

import com.example.urbanmobility.model.RouteDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RouteRepository extends JpaRepository<RouteDetails, Long> {
    void deleteById(long id);
    RouteDetails findById(long id);

}
