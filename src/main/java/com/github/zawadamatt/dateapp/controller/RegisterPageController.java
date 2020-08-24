package com.github.zawadamatt.dateapp.controller;


import com.github.zawadamatt.dateapp.model.User;
import com.github.zawadamatt.dateapp.repository.UserRepository;
import com.github.zawadamatt.dateapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@Controller
public class RegisterPageController {

    private DataSource dataSource;
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public RegisterPageController(DataSource dataSource, UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.dataSource = dataSource;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String RegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "/pages/register.html";
    }

    @PostMapping("/register")
    public String RegisterPage(User user) {
        userService.addUser(user);
        return "/pages/index.html";

    }

    @PostMapping("/user-data")
    public String userData(User user, HttpServletRequest request) {
        userService.addInformationToUser(user, request);
        return "redirect:/";
    }
}
