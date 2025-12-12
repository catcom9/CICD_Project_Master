package com.main.maincontroller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(
        name = "login_mediflow",
        url = "{login.service.base-url}"
)

@RequestMapping("/api/users")
public interface LoginClient {
    @GetMapping("/{username}")
    ResponseEntity<User> getUser(@PathVariable String username);

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user);

    @PutMapping("/{username}")
    ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user);

    @DeleteMapping("/{username}")
    ResponseEntity<User> deleteUser(@PathVariable String username);

}
