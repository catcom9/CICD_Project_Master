package com.main.maincontroller.DTO;

import com.main.maincontroller.LoginDetails;
import com.main.maincontroller.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class PatientAndLoginDetails {
    private Patient patient;
    private LoginDetails details;

}
