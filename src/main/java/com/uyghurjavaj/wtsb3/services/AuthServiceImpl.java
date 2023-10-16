package com.uyghurjavaj.wtsb3.services;

import com.uyghurjavaj.wtsb3.dtos.SignupRequest;
import com.uyghurjavaj.wtsb3.dtos.UserDTO;
import com.uyghurjavaj.wtsb3.exceptions.UserAlreadyExistingException;
import com.uyghurjavaj.wtsb3.model.User;
import com.uyghurjavaj.wtsb3.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(SignupRequest signupRequest) {
        Optional<User> findByEmail = userRepository.findFirstByEmail(signupRequest.getEmail());

        if(findByEmail.isPresent()) {
            log.error("User exists in DB!!");
            throw new UserAlreadyExistingException("User has been already registered with this email: {%s}".formatted(signupRequest.getEmail()));
        }

        User user = new User();
        user.setName(signupRequest.getName());

        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        user.setEmail(signupRequest.getEmail());

        user.setPhoneNumber(signupRequest.getPhoneNumber());

        final User userCreated = userRepository.save(user);

        return UserDTO.builder()
                .id(userCreated.getId())
                .email(userCreated.getEmail())
                .name(userCreated.getName())
                .phoneNumber(userCreated.getPhoneNumber())
                .build();
    }
}
