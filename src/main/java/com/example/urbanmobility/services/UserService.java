package com.example.urbanmobility.services;

import com.example.urbanmobility.model.AuthDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.repository.AuthRepository;
import com.example.urbanmobility.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    // ALL CRUD Operations for Users
    public void saveUser(UserDetails userDetails){
        userRepository.save(userDetails);
    }
    public void deleteUserDetails(String username){
        userRepository.deleteByUsername(username);
    }
    public UserDetails getUserDetails(String username){
        return userRepository.findByUsername(username);
    }
    public List<UserDetails> getAllUserDetails(){
        return userRepository.findAll();
    }
}
