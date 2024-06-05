package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @GetMapping("/quizes")
    public String showQuizesPage() {
        return "quizes";
    }

    @GetMapping("/profile")
    public String showProfilePage() {
        return "profile";
    }

    @GetMapping("/chat")
    public String showChatPage() {
        return "chat";
    }

    @GetMapping("/disciplines")
    public String showDisciplinesPage() {
        return "disciplines";
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/disc_mathematics")
    public String showDiscMathematicsPage() {
        return "disc_mathematics";
    }

    @GetMapping("/lections")
    public String showLectionsPage() {
        return "lections";
    }
}
