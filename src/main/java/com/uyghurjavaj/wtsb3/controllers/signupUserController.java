package com.uyghurjavaj.wtsb3.controllers;

import com.uyghurjavaj.wtsb3.dtos.SignupRequest;
import com.uyghurjavaj.wtsb3.dtos.UserDTO;
import com.uyghurjavaj.wtsb3.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class signupUserController {

    private final AuthService authService;

    public signupUserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody SignupRequest signupRequest) {
        UserDTO createUser = authService.createUser(signupRequest);

        if(createUser == null) {
            return new ResponseEntity<>("Creating user is failed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
}
