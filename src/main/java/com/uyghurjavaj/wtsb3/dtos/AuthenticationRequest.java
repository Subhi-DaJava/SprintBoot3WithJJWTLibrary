package com.uyghurjavaj.wtsb3.dtos;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class AuthenticationRequest {

    @Email
    private String email;

    private String password;
}
