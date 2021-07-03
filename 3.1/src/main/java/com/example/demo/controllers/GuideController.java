package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuideController {
    @GetMapping("/guide-main")
    public String greeting(Model model) {
        model.addAttribute("title", "Гайды.");
        return "guide-main";
    }

}
