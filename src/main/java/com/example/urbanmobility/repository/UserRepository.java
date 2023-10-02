package com.example.urbanmobility.repository;

import com.example.urbanmobility.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByUsername(String username);
    void deleteByUsername(String username);


}