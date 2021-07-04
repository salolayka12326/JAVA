package com.example.demo.controllers;

import com.example.demo.models.Guide;
import com.example.demo.repo.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class GuideController {

    @Autowired
    private GuideRepository guideRepository;

    @GetMapping("/guide-main")
    public String guide(Model model) {

        Iterable<Guide> guides=guideRepository.findAll();
        model.addAttribute("guides",guides);
        model.addAttribute("title", "Гайды.");
        return "guide-main";
    }

    @GetMapping("/guide-main/add")
    public String guideAdd(Model model) {

        return "guide-add";
    }

    @PostMapping("/guide-main/add")
    public String guidePostAdd(@RequestParam String title,@RequestParam String anons,@RequestParam String full, Model model) {

        Guide guide= new Guide(title, anons,full);
        guideRepository.save(guide);

        return "redirect:/guide-main";
    }
    @GetMapping("/guide-main/{id}")
    public String guideDetails(@PathVariable(value = "id")long guideId, Model model) {
        if(!guideRepository.existsById(guideId))
        {
            return "redirect:/guide-main";
        }

        Optional<Guide> guide = guideRepository.findById(guideId);
        ArrayList<Guide> res = new ArrayList<>();
        guide.ifPresent(res::add);
        model.addAttribute("guide", res);
        return "guide-details";
    }

    @GetMapping("/guide-main/{id}/edit")
    public String guideEdit(@PathVariable(value = "id")long guideId, Model model) {
        if(!guideRepository.existsById(guideId))
        {
            return "redirect:/guide-main";
        }

        Optional<Guide> guide = guideRepository.findById(guideId);
        ArrayList<Guide> res = new ArrayList<>();
        guide.ifPresent(res::add);
        model.addAttribute("guide", res);
        return "guide-edit";
    }

    @PostMapping("/guide-main/{id}/edit")
    public String guidePostEdit(@PathVariable(value = "id")long guideId, @RequestParam String title,@RequestParam String anons,@RequestParam String full, Model model) {

        Guide guide= guideRepository.findById(guideId).orElseThrow();
        guide.setTitle(title);
        guide.setAnons(anons);
        guide.setFull(full);
        guideRepository.save(guide);
        return "redirect:/guide-main";
    }

    @PostMapping("/guide-main/{id}/remove")
    public String guidePostDelete(@PathVariable(value = "id")long guideId, Model model) {
        Guide guide= guideRepository.findById(guideId).orElseThrow();
        guideRepository.delete(guide);

    return "redirect:/guide-main";
    }
}
