package com.example.week8.controller;


import com.example.week8.dto.AuthorDto;
import com.example.week8.dto.NoteDto;
import com.example.week8.service.AuthorService;
import com.example.week8.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AppController {
    private NoteService noteService;
    private AuthorService authorService;

    @Autowired
    public AppController(NoteService noteService, AuthorService authorService) {
        this.noteService = noteService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getMainPage(Model model){
        model.addAttribute("noteDto", new NoteDto());
        model.addAttribute("authorDto", new AuthorDto());
        model.addAttribute("notes", noteService.getAllNotes());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "main";
    }

    @PostMapping("/note")
    public String addNewNote(@ModelAttribute("noteDto") @Valid NoteDto noteDto,
                             BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("info", "Coś poszło nie tak!");
            return "main";
        }else {
            noteService.addNewNote(noteDto);
            return "redirect:/";
        }
    }

    @PostMapping("/author")
    public String addNewAuthor(@ModelAttribute("authorDto") @Valid AuthorDto authorDto,
                             BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("info", "Coś poszło nie tak!");
            return "main";
        }else {
            authorService.addNewAuthor(authorDto);
            return "redirect:/";
        }
    }
}
