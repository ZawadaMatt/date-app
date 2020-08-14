package com.github.zawadamatt.dateapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class LoginPageController {

  @Autowired
  private DataSource dataSource;


  @GetMapping("/login")
  @ResponseBody
    public String StartPage() {
      return "done";
  }

}
