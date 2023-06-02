package com.example.mvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @RequestMapping("/login")
  public String login(Model model) {
	  
	  
		model.addAttribute("fecha", new Date());

    return "login";
  }
  
  
}