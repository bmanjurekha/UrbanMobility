package com.example.urbanmobility.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.urbanmobility.model.AuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired(required = false) // disable spring bean evaluation
    private AuthService authService;

    public String getToken(AuthDetails auth) {
        var username = auth.getUsername();
        var password = auth.getPassword();

        if(authService.authenticate(username, password)) {
            return JWT.create()
                    .withClaim("username", username)
                    .sign(Algorithm.HMAC256("supersecret"));
        } else {
            return null;
        }
    }
    public String generateToken(String username) {
        return JWT.create()
                .withClaim("username", username)
                .sign(Algorithm.HMAC256("supersecret"));
    }
}