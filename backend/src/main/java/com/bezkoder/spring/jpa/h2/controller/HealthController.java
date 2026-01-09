package com.bezkoder.spring.jpa.h2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot API running";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
