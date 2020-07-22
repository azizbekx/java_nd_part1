package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    private NotesService notesService;

    public HomeController(NotesService notesService){

        this.notesService = notesService;
    }
    @GetMapping("/home")
    public String getHomepage(
            @ModelAttribute("notes") Notes notes  ,
//            @ModelAttribute("credintials") ,
            Authentication authentication,
            Model model
    ) {

        String username = (String) authentication.getPrincipal();

        Map<String, Object> data = new HashMap<>();

        data.put("noteData", this.notesService.getNoteByUsername(username));
//        data.put("credentialList", this.notesService.getCredentialsByUsername(username));
//        data.put("fileList", this.notesService.getFilesByUser(username));

        model.addAllAttributes(data);

        return "home";
    }
    @GetMapping("/result")
    public String showResult(
            Authentication authentication,
            @RequestParam(required = false, name = "isSuccess") Boolean isSuccess,
            @RequestParam(required = false, name = "errorType") Integer errorType,
            Model model
    ) {

        Map<String, Object> data = new HashMap<>();

        data.put("isSuccess", isSuccess);
        data.put("errorType", errorType);

        model.addAllAttributes(data);

        return "result";
    }

}
