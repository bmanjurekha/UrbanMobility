package com.example.urbanmobility.services;

import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;


    @InjectMocks
    UserService userService = new UserService();
    @Test
    void verifyGetUser(){
        var userDetails = UserDetails
                .builder()
                .username("manjurekha")
                .id(1)
                .accountnumber("")
                .email("bmanjurekha@gmail.com")
                .phone("07645525654654")
                .role("Supplier")
                .swishnumber("076455525252")
                .build();
        when(userRepository.findByUsername("manjurekha")).thenReturn(userDetails);
        userService.getUserDetails("manjurekha");
        verify(userRepository).findByUsername(anyString());
    }
}
