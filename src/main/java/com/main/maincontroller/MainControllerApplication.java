package com.main.maincontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MainControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainControllerApplication.class, args);
    }

}
