package com.udacity.jwdnd.c1.rewiev;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String goHomePage(Model model){
        model.addAttribute("greetings", new String[]{ "Hi", "hello", "goodbye"});
        return "home";
    }
}
