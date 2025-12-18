package com.main.maincontroller.DTO;

import com.main.maincontroller.Appointment;
import com.main.maincontroller.AppointmentCreate;
import com.main.maincontroller.LoginDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class AppAndLoginDetails {
    private AppointmentCreate appointment;
    private LoginDetails details;
}
