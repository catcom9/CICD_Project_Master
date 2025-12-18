package com.main.maincontroller.DTO;

import com.main.maincontroller.LoginDetails;
import com.main.maincontroller.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class NewUserAndLoginDetails {
    private User user;
    private LoginDetails details;
}
