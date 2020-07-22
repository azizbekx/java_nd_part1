package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NotesService {
    private NotesMapper notesMapper;

    public NotesService(NotesMapper notesMapper) {
        this.notesMapper = notesMapper;
    }

    @PostConstruct
    public void PostConstructor() {
        System.out.println("Create Notes Service Bean");
    }

    public void addNotes(Notes notes) {
        Notes newNotes = new Notes();
        newNotes.setNoteTitle(notes.getNoteTitle());
        newNotes.setNoteDescription(notes.getNoteDescription());

        notesMapper.addNotes(newNotes);
    }

    public List<Notes> getNotes() {
        return notesMapper.getAllNotes();
    }
    public void deleteNote(int noteId){
        notesMapper.deleteNote(noteId);
    }

}

