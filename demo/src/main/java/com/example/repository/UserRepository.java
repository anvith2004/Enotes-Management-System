package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
    
    public boolean existsByEmail(String email);

    public User findByEmail(String email);
}
