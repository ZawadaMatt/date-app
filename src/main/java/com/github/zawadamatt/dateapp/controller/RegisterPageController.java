package com.github.zawadamatt.dateapp.controller;


import com.github.zawadamatt.dateapp.model.User;
import com.github.zawadamatt.dateapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterPageController(DataSource dataSource, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String RegisterPage() {
        return "/pages/register.html";
    }

    @PostMapping("/register")
    public String RegisterPage(HttpServletRequest request) {
        String username = request.getParameter("username");

        if (userRepository.findUserByUsername(username) != null) {
            return "/pages/register.html";
        }
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return "/pages/index.html";

    }

}
