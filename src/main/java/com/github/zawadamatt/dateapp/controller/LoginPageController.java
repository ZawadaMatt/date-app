package com.github.zawadamatt.dateapp.controller;

import com.github.zawadamatt.dateapp.dto.UserDTO;
import com.github.zawadamatt.dateapp.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginPageController {

    private SessionService sessionService;
    private UserDTO userDTO;

    @Autowired
    public LoginPageController(SessionService sessionService, UserDTO userDTO) {
        this.sessionService = sessionService;
        this.userDTO = userDTO;

    }

    @GetMapping("/")
    public String loggedUser(Model model) {

        if (sessionService.actualSessionUser() != null) {
            model.addAttribute("user", sessionService.actualSessionUser());
            if (sessionService.actualSessionUser().getName() == null) {
                return "/pages/firstlogin.html";
            }
            return "/pages/loggedindex.html";
        }
        return "/pages/index.html";
    }

    @GetMapping("/logged")
    @ResponseBody
    public String logged() {
        return "zalogowany !";
    }



}
