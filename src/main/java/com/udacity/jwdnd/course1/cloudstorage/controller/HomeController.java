package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    private NotesService notesService;

//    @GetMapping(value = {"/", "/home"})
//    public ModelAndView getHomePage() throws Exception {
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("noteData", notesService.getNotes());
//        return modelAndView;
//    }
    @GetMapping
    public String  getHomePage(Model model) {
        model.addAttribute("noteData", notesService.getNotes());
        return "home";
    }
//    private NotesService notesService;
//
//    public HomeController(NotesService notesService){
//        this.notesService = notesService;
//    }
//
//    @GetMapping
//    public String getNotesData(NotesInput notesInput, Model model){
//        model.addAttribute("noteData", this.notesService.getNotes());
//        return "home";
//    }
//
//    @PostMapping
//    public String postNotesData(NotesInput notesInput, Model model){
//        this.notesService.addNotes(notesInput);
//        notesInput.setNoteTitle("");
//        notesInput.setNoteDescription("");
//        model.addAttribute("noteData", this.notesService.getNotes());
//        return "home";
//    }
}
