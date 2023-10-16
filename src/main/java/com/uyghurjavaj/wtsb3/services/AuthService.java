package com.uyghurjavaj.wtsb3.services;

import com.uyghurjavaj.wtsb3.dtos.SignupRequest;
import com.uyghurjavaj.wtsb3.dtos.UserDTO;

public interface AuthService {

    UserDTO createUser(SignupRequest signupRequest);
}
