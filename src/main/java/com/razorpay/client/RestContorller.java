package com.razorpay.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = {"com.razorpay.client"})
public class RestContorller {
    public static void main(String[] args) {
        SpringApplication.run(RestController.class, args);
    }
}
