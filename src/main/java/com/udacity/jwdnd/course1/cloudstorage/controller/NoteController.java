package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NoteController {

    private NotesService notesService;

    public NoteController(NotesService notesService){
        this.notesService = notesService;
    }

    @GetMapping("/note/delete")
    public String deleteNotesData(int noteId ){

        notesService.deleteNote(noteId);
        return "redirect:/result?success";
    }

    @PostMapping("/note")
    public String postNotesData(Notes notes){
        this.notesService.addNotes(notes);
        notes.setNoteTitle("");
        notes.setNoteDescription("");
        notesService.addNotes(notes);
        return "redirect:/result?success";
    }
}
