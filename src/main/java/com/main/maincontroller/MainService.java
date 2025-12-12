package com.main.maincontroller;

import lombok.extern.java.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MainService {

    private final LoginClient loginClient;

    public MainService(LoginClient loginClient){
        this.loginClient = loginClient;
    }

    public ResponseEntity<User> createUser(LoginDetails currentUser, User newUser) {
        //Check Login details
        ResponseEntity<User> details = loginClient.getUser(currentUser.getUserName());
        if (!details.hasBody()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        //Check Password
        if (!Objects.equals(details.getBody().getPassword(), currentUser.getPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        //Check Permissions
        if(!Objects.equals(details.getBody().getRole(), "0")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        loginClient.createUser(newUser);

        return ResponseEntity.status(201).body(newUser);
    }

}
