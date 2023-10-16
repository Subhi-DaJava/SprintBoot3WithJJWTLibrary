package com.uyghurjavaj.wtsb3.repositories;

import com.uyghurjavaj.wtsb3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);
}
