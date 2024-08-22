package com.example.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Notes;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.NotesService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRepository userRepo;

    @Autowired
    public NotesService notesService;

    @ModelAttribute
    public User getUser(Principal p, Model m) {
        String email = p.getName();// UserName of the Logged in User.
        User user = userRepo.findByEmail(email);
        m.addAttribute("user", user);
        return user;
    }

    @GetMapping("/addNotes")
    public String addNotes() {
        return "add_notes";
    }

    @GetMapping("/editNotes/{id}")
    public String editNotes(@PathVariable int id, Model m) {
        Notes notes = notesService.getNotesById(id);
        m.addAttribute("n", notes);
        return "edit_notes";
    }

    @GetMapping("/viewNotes")
    public String viewNotes(Principal p, Model m) {
        User user = getUser(p, m);
        List<Notes> notes = notesService.getNotesByUser(user);
        m.addAttribute("notesList", notes);
        return "view_notes";
    }

    @PostMapping("/saveNotes")
    public String saveNotes(@ModelAttribute Notes notes, HttpSession session, Principal p, Model m) {
        notes.setLocalDate(LocalDate.now());
        notes.setUser(getUser(p, m));
        Notes notes2 = notesService.saveNotes(notes);
        if (notes2 != null) {
            session.setAttribute("msg", "Register Successful");
        } else {
            session.setAttribute("msg", "Something Wrong On Server");
        }

        return "redirect:/user/addNotes";
    }

    @PostMapping("/updateNotes")
    public String updateNotes(@ModelAttribute Notes notes, HttpSession session, Principal p, Model m) {
        notes.setLocalDate(LocalDate.now());
        notes.setUser(getUser(p, m));
        Notes notes2 = notesService.saveNotes(notes);
        if (notes2 != null) {
            session.setAttribute("msg", "Note Update Successful");
        } else {
            session.setAttribute("msg", "Something Wrong On Server");
        }

        return "redirect:/user/viewNotes";
    }

    @GetMapping("/deleteNotes/{id}")
    public String deleteNotes(@PathVariable int id, HttpSession session) {
        boolean f = notesService.deleteNotes(id);
        if (f != false) {
            session.setAttribute("msg", "Note Delete Successful");
        } else {
            session.setAttribute("msg", "Something Wrong On Server");
        }
        return "redirect:/user/viewNotes";
    }

}
