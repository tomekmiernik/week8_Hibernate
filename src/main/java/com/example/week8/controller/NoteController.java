package com.example.week8.controller;


import com.example.week8.dto.AuthorDto;
import com.example.week8.dto.NoteDto;
import com.example.week8.service.AuthorService;
import com.example.week8.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class NoteController {
    private NoteService noteService;
    private AuthorService authorService;

    @Autowired
    public NoteController(NoteService noteService, AuthorService authorService) {
        this.noteService = noteService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getMainPage(Model model) {
        initializeAttributes(model);
        return "main";
    }

    @PostMapping("/note")
    public String addNewNote(@ModelAttribute("noteDto") @Valid NoteDto noteDto,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("info", "Coś poszło nie tak!");
            initializeAttributes(model);
            return getMainPage(model);
        } else {
            noteService.addNewNote(noteDto);
            return "redirect:" + getMainPage(model);
        }
    }

    @GetMapping("/updateNote/{noteId}")
    public String getFormToUpdateNote(@PathVariable("noteId") long noteId, Model model) {
        model.addAttribute("noteDto", noteService.getNodeById(noteId));
        return "updateNote";
    }


    /*There was an unexpected error (type=Method Not Allowed, status=405).
        Request method 'POST' not supported*/
    @PutMapping("/updateNote")
    public String updateNote(@ModelAttribute("noteDto") @Valid NoteDto noteDto,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("info", "Coś poszło nie tak!");
            initializeAttributes(model);
            return getMainPage(model);
        } else {
            noteService.updateNote(noteDto);
            return "redirect:" + getMainPage(model);
        }
    }

    @PostMapping("/author")
    public String addNewAuthor(@ModelAttribute("authorDto") @Valid AuthorDto authorDto,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("info", "Coś poszło nie tak!");
            initializeAttributes(model);
            return "main";
        } else {
            authorService.addNewAuthor(authorDto);
            return "redirect:/";
        }
    }

    private void initializeAttributes(Model model) {
        model.addAttribute("noteDto", new NoteDto());
        model.addAttribute("authorDto", new AuthorDto());
        model.addAttribute("notes", noteService.getAllNotes());
        model.addAttribute("authors", authorService.getAllAuthors());
    }
}
