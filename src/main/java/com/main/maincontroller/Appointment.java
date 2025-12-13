package com.main.maincontroller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Appointment {
    private Long appointmentId;
    private String patientUserName;
    private String venue;
    private LocalDate date;
    private LocalTime time;
    private String doctorUserName;
}
