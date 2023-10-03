package com.example.urbanmobility.services;
import com.example.urbanmobility.model.AuthDetails;
import com.example.urbanmobility.repository.AuthRepository;
import com.example.urbanmobility.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AuthServiceImplementationTest {

    @Mock
    UserRepository userRepository;

    @Mock
    AuthRepository authRepository;

    @InjectMocks
    AuthService authService = new AuthServiceImplementation();
    @Test
    void verifyIsAuthenticatedUser(){
        var auth = AuthDetails
                .builder()
                .username("manjurekha")
                .password("supersecret").build();


        when(authRepository.findByUsername("manjurekha")).thenReturn(auth);

        authService.authenticate("manjurekha","supersecret");

        verify(authRepository,times(1)).findByUsername("manjurekha");

    };

}
