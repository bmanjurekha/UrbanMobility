package com.example.urbanmobility.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDetails {

    private String username;
    private String password;
}