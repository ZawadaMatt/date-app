package com.github.zawadamatt.dateapp.dto;

import com.github.zawadamatt.dateapp.model.User;
import com.github.zawadamatt.dateapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDTO {

    @Autowired
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public boolean isPassCorrect(String username, String password) {

        User user = userRepository.findUserByUsername(username);

        return user.getPassword().equals(passwordEncoder.encode(password));
    }

}
