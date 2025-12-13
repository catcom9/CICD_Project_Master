package com.main.maincontroller;

import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final MainService mainService;


    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @PostMapping("users/new")
    public ResponseEntity<User> createUser(@Valid @RequestBody NewUserAndLoginDetails details){
        User newUser = details.getUser();
        LoginDetails currentUser = details.getDetails();

        return mainService.createUser(currentUser, newUser);
    }

    @PutMapping("users/update/{newPass}")
    public ResponseEntity<User> updateUserPassword(@Valid @RequestBody LoginDetails details, @PathVariable String newPass){

        return mainService.updateUserPassword(details, newPass);
    }

    @DeleteMapping("users/delete/{userName}")
    public ResponseEntity<User> deleteUser(@Valid LoginDetails details, @PathVariable String userName){
        return mainService.deleteUser(details, userName);
    }




}
