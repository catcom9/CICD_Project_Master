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

    public ResponseEntity<User> createUser(LoginDetails details, User newUser) {
        //Check Login details
        ResponseEntity<User> userData = loginClient.getUser(details.getUserName());
        if (!userData.hasBody()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //Check Password
        if (!Objects.equals(userData.getBody().getPassword(), details.getPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        //Check Permissions
        if(!Objects.equals(userData.getBody().getRole(), "0")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        loginClient.createUser(newUser);

        return ResponseEntity.status(201).body(newUser);
    }

    public ResponseEntity<User> updateUserPassword(LoginDetails details, String newPass){
        ResponseEntity<User> userData = loginClient.getUser(details.getUserName());
        if (!userData.hasBody()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(userData.getBody().getPassword(), details.getPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        User newUser = new User(details.getUserName(), newPass, userData.getBody().getRole());

        return loginClient.updateUser(details.getUserName(), newUser);

    }


    public ResponseEntity<User> deleteUser(LoginDetails details, String userName){
        //Check Login details
        ResponseEntity<User> userData = loginClient.getUser(details.getUserName());
        if (!userData.hasBody()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //Check Password
        if (!Objects.equals(userData.getBody().getPassword(), details.getPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        //Check Permissions
        if(!Objects.equals(userData.getBody().getRole(), "0")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return loginClient.deleteUser(userName);
    }



}
