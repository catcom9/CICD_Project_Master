package com.main.maincontroller.Micoservices;

import com.main.maincontroller.Patient;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "recordsMediflow",
        url = "${records.base-url}"
)

public interface RecordsInterface {
    @PostMapping("/api/Patients")
    Patient create(@RequestBody Patient person);

    @GetMapping("/api/Patients/{user}")
    Patient byUsername(@Valid @PathVariable String user);

    @DeleteMapping("/api/Patients/{user}")
    void delete(@Valid @PathVariable String user);

}
