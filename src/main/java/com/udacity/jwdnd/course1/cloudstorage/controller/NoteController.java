package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class NoteController {
    //
//    @GetMapping("/note/delete")
//    public String getNotesData(int noteId){
//        notesService.deleteNote(noteId);
//        return "redirect:/result?success";
//    }
//
//    @PostMapping("/note")
//    public String postNotesData(Notes notes, Model model){
//        this.notesService.addNote(notes);
//        return "redirect:/result?success";
//    }
    //    private NotesService notesService;
//
//    public NoteController(NotesService notesService){
//        this.notesService = notesService;
//    }
//
//    @GetMapping("note/delete")
//    public String deleteNotesData(int noteId ){
//        notesService.deleteNote(noteId);
//        return "redirect:/result?success";
//    }
//
//    @PostMapping("note")
//    public String postNotesData(Notes notes){
//        this.notesService.addNotes(notes);
//        notes.setNoteTitle("");
//        notes.setNoteDescription("");
//        notesService.addNotes(notes);
//        return "redirect:/result?success";
//    }
    private NotesService notesService;

    private NoteController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("/note")
    public String noteSubmit(
            @ModelAttribute("notes") Notes notes,
            Authentication authentication,
            Model model
    ) {
        String username = authentication.getPrincipal().toString();
        Boolean isSuccess = this.notesService.createOrUpdateNote(username, notes);
        return "redirect:/result?isSuccess=" + isSuccess;

    }

    @GetMapping("/note")
    public String noteDelete(
            @ModelAttribute("notes") Notes notes,
            @RequestParam(required = false, name = "noteId") Integer noteId,
            Authentication authentication,
            Model model
    ) {
        String username = authentication.getPrincipal().toString();

        Boolean isSuccess = this.notesService.deleteNote(noteId, username);
        return "redirect:/result?isSuccess=" + isSuccess;
    }
}
