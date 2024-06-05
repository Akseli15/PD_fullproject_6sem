package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class PageController {

    @GetMapping("/quizes")
    public String showQuizesPage() {
        return "quizes.html";
    }

    @GetMapping("/profile")
    public String showProfilePage() {
        return "profile";
    }

    @GetMapping("/chat")
    public String showChatPage() {
        return "chat.html";
    }

    @GetMapping("/disciplines")
    public String showDisciplinesPage() {
        return "disciplines.html";
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index.html";
    }

    @GetMapping("/disc_mathematics")
    public String showDiscMathematicsPage() {
        return "disc_mathematics.html";
    }

    @GetMapping("/lections")
    public String showLectionsPage() {
        return "lections.html";
    }
}
