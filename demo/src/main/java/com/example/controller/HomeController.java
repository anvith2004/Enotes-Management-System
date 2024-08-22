package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    public UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession session) {
        boolean f = userService.existEmailCheck(user.getEmail());

        if (!f) {
            User saveUser = userService.saveUser(user);
            if (saveUser != null) {
                session.setAttribute("msg", "Register Successful");
            } else {
                session.setAttribute("msg", "Something Wrong On Server");
            }
        }

        return "redirect:/register";
    }

}
