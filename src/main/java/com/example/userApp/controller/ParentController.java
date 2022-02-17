package com.example.userApp.controller;

import com.example.userApp.dto.ParentDTO;
import com.example.userApp.model.Address;
import com.example.userApp.model.Parent;
import com.example.userApp.repository.AddressRepository;
import com.example.userApp.repository.ChildRepository;
import com.example.userApp.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("parent")
@RequiredArgsConstructor
public class ParentController {

    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;
    private final AddressRepository addressRepository;


    @GetMapping
    public String showParents(Model model) {
        model.addAttribute("parents", parentRepository.findAll());
        return "showUsers";
    }

    @GetMapping("{id}/update")
    public String showUpdatePage(@PathVariable Integer id, Model model) {
        var parent = parentRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model.addAttribute("parentDTO", new ParentDTO(parent));
        return "updateParent";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("parentDTO", new ParentDTO());
        return "createParent";
    }


    @PostMapping("create")
    public String createParent(@ModelAttribute ParentDTO parentDTO) {
        var address = addressRepository.save(new Address(parentDTO));
        parentRepository.save(new Parent(parentDTO, address));
        return "redirect:/user";
    }

    @PostMapping("{id}/delete")
    public String deleteParent(@PathVariable Integer id) {
        var parent = parentRepository.findById(id);
        var childs = childRepository.findAllByParent(parent);
        childRepository.deleteAll(childs);
        parentRepository.deleteById(id);
        return "redirect:/user";
    }

    @PostMapping("{id}/update")
    public String updateParent(@PathVariable Integer id, @ModelAttribute ParentDTO parentDTO) {
        var parent = parentRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        parent.setFirstName(parentDTO.getFirstName());
        parent.setLastName(parentDTO.getLastName());
        parentRepository.save(parent);

        var address = parent.getAddress();
        address.setStreet(parentDTO.getStreet());
        address.setCity(parentDTO.getCity());
        address.setState(parentDTO.getState());
        address.setZip(parentDTO.getZip());
        addressRepository.save(address);

        return "redirect:/user";
    }
}
