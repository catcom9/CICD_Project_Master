package com.main.maincontroller;

import lombok.extern.java.Log;
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
            //User not found, Do error stuff here
            // TODO
        }

        //Check Password
        if (!Objects.equals(details.getBody().getPassword(), currentUser.getPassword())){
            // Passwords do not match, Do more error stuff here
            // TODO
        }

        //Check Permissions
        if(!Objects.equals(details.getBody().getRole(), "0")){
            // Not an admin cant make new users, Do even more error stuff
            // TODO
        }

        loginClient.createUser(newUser);

        return ResponseEntity.created();
    }
}
