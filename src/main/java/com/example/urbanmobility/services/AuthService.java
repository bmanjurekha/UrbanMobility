package com.example.urbanmobility.services;

import com.example.urbanmobility.model.AuthDetails;
import com.example.urbanmobility.model.UserDetails;
import org.springframework.stereotype.Service;


public interface AuthService {
    boolean authenticate(String username, String password);
    AuthDetails authenticate(String usertoken);
    void save(AuthDetails authDetails);
     boolean isAuthenticatedUser(String usertoken);
}