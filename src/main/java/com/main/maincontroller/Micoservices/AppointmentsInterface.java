package com.main.maincontroller.Micoservices;

import com.main.maincontroller.Appointment;
import com.main.maincontroller.AppointmentCreate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "AppointmentsMediflow",
        url = "${appointments.base-url}"
)

public interface AppointmentsInterface {
    @PostMapping("/appointments")
    ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentCreate request);

    @GetMapping("/appointments/patient/{patientUserName}")
    ResponseEntity<List<Appointment>> getByPatient(@PathVariable String patientUserName);

    @GetMapping("/appointments/doctor/{doctorUserName}")
    public ResponseEntity<List<Appointment>> getByDoctor(@PathVariable String doctorUserName);

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id);


    @PutMapping("/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @RequestBody AppointmentCreate request
    );
}
