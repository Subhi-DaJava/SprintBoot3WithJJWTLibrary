package com.uyghurjavaj.wtsb3.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<Map<String, String>> greeting() {
        Map<String, String> greeting = new HashMap<>();
        greeting.put("Greeting", "Hi from JWT Authorization");
        log.info("Hi from JWT Authorization, in HomeController");
        return ResponseEntity.ok(greeting);
    }

}
