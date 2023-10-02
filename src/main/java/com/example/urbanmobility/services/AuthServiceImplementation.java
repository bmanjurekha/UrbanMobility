package com.example.urbanmobility.services;
import com.example.urbanmobility.model.AuthDetails;
import com.example.urbanmobility.model.UserDetails;
import com.example.urbanmobility.repository.AuthRepository;
import com.example.urbanmobility.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService {

    @Autowired
    AuthRepository authRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        AuthDetails auth = authRepository.findByUsername(username);
        if(auth!=null)
            return auth.getPassword().equals(password);
        else
            return false;
    }
    @Override
    public AuthDetails authenticate(String usertoken){
        return authRepository.findByusertoken(usertoken);
    }

    public boolean isAuthenticatedUser(String usertoken){
        AuthDetails auth = authRepository.findByusertoken(usertoken);
        if(auth!=null) {
            if (!(auth.getUsername().isEmpty() || auth.getUsername().isBlank())) {
                return true;
            }
            return false;
        }
        return false;

    }
    public void save(AuthDetails authDetails){ authRepository.save(authDetails);}

}





