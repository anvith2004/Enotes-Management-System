package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Notes;
import com.example.entity.User;
import com.example.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    public NotesRepository notesRepository;

    @Override
    public Notes saveNotes(Notes notes) {
        return notesRepository.save(notes);
    }

    @Override
    public Notes getNotesById(int id) {
        return notesRepository.findById(id).get();
    }

    public List<Notes> getNotesByUser(User user) {
        return notesRepository.findByUser(user);
    }

    public Notes updateNotes(Notes notes) {
        return notesRepository.save(notes);
    }

    public boolean deleteNotes(int id) {
        // Notes notes = notesRepository.findById(id).get();
        Notes notes = getNotesById(id);
        if (notes != null) {
            notesRepository.delete(notes);
            return true;
        }
        return false;
    }

}
