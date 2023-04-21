package com.lab254.librarysystem.users;

import com.lab254.librarysystem.users.domain.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("password") String password, HttpServletResponse response) {
        User user = userService.login(userId, password);
        Cookie cookie = new Cookie("userId", user.getId().toString());
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "login-result";
    }

    @PostMapping("/register")
    public String register(@RequestParam("userId") String userId, @RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        User user = new User();
        System.out.println("user = " + user);
        user.setUserId(userId);
        user.setName(name);
        user.setPassword(password);
        user = userService.createUser(user);

        model.addAttribute("user", user);
        return "reg-result";
    }
}
