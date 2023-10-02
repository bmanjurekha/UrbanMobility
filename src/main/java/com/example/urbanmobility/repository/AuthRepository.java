package com.example.urbanmobility.repository;
import com.example.urbanmobility.model.AuthDetails;
import com.example.urbanmobility.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthDetails, Long> {
    AuthDetails findByUsername(String username);
    AuthDetails findByusertoken(String userToken);
}
