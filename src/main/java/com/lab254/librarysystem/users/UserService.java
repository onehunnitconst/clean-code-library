package com.lab254.librarysystem.users;

import com.lab254.librarysystem.users.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserJpaRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User login(String userId, String password) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalStateException());
        System.out.println("user.getUserId() = " + user.getUserId());
        if (user.getPassword().compareTo(password) != 0) {
            throw new IllegalStateException();
        }
        return user;
    }

    public User findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        return user;
    }
}
