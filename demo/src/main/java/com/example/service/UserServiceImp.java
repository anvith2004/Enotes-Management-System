package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.entity.User;
import com.example.repository.UserRepository;

import jakarta.servlet.ServletRegistration;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserRepository userRepo;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public User saveUser(User user) {
        user.setRole("ROLE_USER");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User newUser = userRepo.save(user);
        return newUser;
    }

    public boolean existEmailCheck(String email) {
        return userRepo.existsByEmail(email);
    }

    public void removeSessionMessage() {
        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
        session.removeAttribute("msg");
    }

}
