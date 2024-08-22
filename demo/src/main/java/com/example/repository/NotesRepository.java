package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Notes;
import com.example.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer>{
    
    public List<Notes> findByUser(User user);

}
