package com.example.demo.controller;

import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("parents", parentRepository.findAll());
        model.addAttribute("childs", childRepository.findAll());
        return "showUsers";
    }
}
