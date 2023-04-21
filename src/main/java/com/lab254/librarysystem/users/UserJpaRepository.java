package com.lab254.librarysystem.users;

import com.lab254.librarysystem.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}
