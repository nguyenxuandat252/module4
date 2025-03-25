package com.example.musicapplication.controller;

import com.example.musicapplication.model.Music;
import com.example.musicapplication.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/musicList")
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @GetMapping("")
    public String showList(Model model){
        List<Music> musicList = musicService.getAll();
        model.addAttribute("musicList",musicList);
        return "/music/list";
    }
    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("music", new Music());
        return "/music/add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Music music) {
        musicService.add(music);
        return "redirect:/musicList";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        Music music = musicService.findByID(id);
        model.addAttribute("music", music);
        return "/music/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Music music) {
        musicService.updateMusic(music);
        return "redirect:/musicList";
    }
    @GetMapping("/search")
    public String searchName(@RequestParam("keyword") String keyword, Model model) {
        List<Music> musicList = musicService.searchName(keyword);
        model.addAttribute("musicList", musicList);
        return "/music/list";
    }
}
