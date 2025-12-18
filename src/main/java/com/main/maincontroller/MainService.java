package com.main.maincontroller;

import com.main.maincontroller.DTO.AppAndLoginDetails;
import com.main.maincontroller.Micoservices.AppointmentsInterface;
import com.main.maincontroller.Micoservices.LoginClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MainService {

    private final LoginClient loginClient;

    private final AppointmentsInterface appInterface;

    public MainService(LoginClient loginClient, AppointmentsInterface appInterface){
        this.loginClient = loginClient;
        this.appInterface = appInterface;
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


    public ResponseEntity<Appointment> createAppointment(AppAndLoginDetails newApp) {
        ResponseEntity<User> userData = loginClient.getUser(newApp.getDetails().getUserName());
        if (CheckLogin(newApp.getDetails()) != 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(!Objects.equals(userData.getBody().getRole(), "1")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return appInterface.createAppointment(newApp.getAppointment());
    }


    private int CheckLogin(LoginDetails details){
        ResponseEntity<User> userData = loginClient.getUser(details.getUserName());

        if (!userData.hasBody()){
            return 1;
        }

        //Check Password
        if (!Objects.equals(userData.getBody().getPassword(), details.getPassword())){
            return 2;
        }

        return  0;

    }


    public ResponseEntity<List<Appointment>> getAppByPatient(String userName) {
        return appInterface.getByPatient(userName);
    }

    public ResponseEntity<List<Appointment>> getAppByDoctor(String userName) {
        return appInterface.getByDoctor(userName);
    }


}
