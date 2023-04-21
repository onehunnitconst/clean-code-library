package com.lab254.librarysystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String loginPage(@CookieValue(name = "userId", required = false) String userId) {
        if (userId != null) {
            return "redirect:books";
        }
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
}
