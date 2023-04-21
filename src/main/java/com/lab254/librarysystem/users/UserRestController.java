package com.lab254.librarysystem.users;

import com.lab254.librarysystem.users.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userService.findUserById(Long.parseLong(id));
        return ResponseEntity.ok(user);
    }
}
