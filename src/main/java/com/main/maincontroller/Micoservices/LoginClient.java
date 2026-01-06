package com.main.maincontroller.Micoservices;

import com.main.maincontroller.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "loginMediflow",
        url = "${login.base-url}"
)

public interface LoginClient {
    @GetMapping("/api/users/{username}")
    ResponseEntity<User> getUser(@PathVariable String username);

    @PostMapping("/api/users")
    ResponseEntity<User> createUser(@RequestBody User user);

    @PutMapping("/api/users/{username}")
    ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user);

    @DeleteMapping("/api/users/{username}")
    ResponseEntity<User> deleteUser(@PathVariable String username);

}
