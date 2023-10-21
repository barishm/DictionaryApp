package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.WordCreateBindingModel;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.service.impl.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/words")
public class WordController {
    private final LoggedUser loggedUser;
    private final WordService wordService;

    public WordController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @GetMapping("/create")
    public ModelAndView create(@ModelAttribute("wordCreateBindingModel") WordCreateBindingModel wordCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("word-add");
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("wordCreateBindingModel") @Valid WordCreateBindingModel wordCreateBindingModel, BindingResult bindingResult) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("word-add");
        }

        boolean isCreated = wordService.create(wordCreateBindingModel);

        String view = isCreated ? "redirect:/home" : "create";
        return new ModelAndView(view);
    }

    @PostMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        wordService.remove(id);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/remove-all")
    public ModelAndView removeAll(){
        wordService.removeAll();
        return new ModelAndView("redirect:/home");
    }

}
