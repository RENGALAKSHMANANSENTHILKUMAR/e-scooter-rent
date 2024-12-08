package com.example.e_scooter_rent.controller;

import com.example.e_scooter_rent.model.User;
import com.example.e_scooter_rent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Handle form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.register(user); // Save user data to the database
            model.addAttribute("success", "Registration successful!");
            return "login"; // Redirect to login page after successful registration
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred: " + e.getMessage());
            return "register";
        }
    }

    // Show login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Thymeleaf view name
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {
        Optional<User> user = userService.login(email, password);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "dashboard"; // Redirect to user dashboard
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
