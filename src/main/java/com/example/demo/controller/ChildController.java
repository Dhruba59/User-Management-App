package com.example.demo.controller;

import com.example.demo.model.Child;
import com.example.demo.model.Parent;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("child")
@RequiredArgsConstructor
public class ChildController {

    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;


    @GetMapping("/create")
    public String showForm(Model model) {
        Child child = new Child();
        List<Parent> parentList = (List<Parent>) parentRepository.findAll();

        model.addAttribute("child", child);
        model.addAttribute("parentList", parentList);

        return "createChild";
    }

    @GetMapping("{id}/update")
    public String showUpdatePage(@PathVariable Integer id, Model model) {
        var child = childRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("parentList", parentRepository.findAll());
        model.addAttribute("child", child);
        return "updateChild";
    }

    @PostMapping("/create")
    public String submitForm(@ModelAttribute("child") Child child) {
        childRepository.save(child);
        return "redirect:/user";
    }

    @PostMapping("{id}/delete")
    public String deleteChild(@PathVariable Integer id) {
        childRepository.deleteById(id);
        return "redirect:/user";
    }

    @PostMapping("{id}/update")
    public String updateChild(@PathVariable Integer id, @ModelAttribute Child child) {

        childRepository.save(child);
        return "redirect:/user";
    }
//
//
//    @PostMapping("/child")
//    public void saveChild(@RequestBody Child child) {
//        childRepository.save(child);
//    }
//
//    @PutMapping("/child")
//    public void updateChild(@RequestBody Child child) {
//        childRepository.save(child);
//    }

}
