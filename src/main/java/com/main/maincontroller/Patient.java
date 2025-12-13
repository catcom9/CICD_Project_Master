package com.main.maincontroller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Patient {
    private String username;
    private String name;
    private String email;
    private String DOB;
    private String gender;
    private String address;
    private String phone;
    private String docter;
}
