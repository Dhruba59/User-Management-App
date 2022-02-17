package com.example.userApp.controller;

import com.example.userApp.model.Address;
import com.example.userApp.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressRepository addressRepository;

//    @GetMapping("/address")
//    public String getAllAddress() {
//        return "address";
//    }

    @RequestMapping("/address")
    public String showForm(Model model) {
        Address address = new Address();
//        List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");

        model.addAttribute("address", address);
//        model.addAttribute("professionList", professionList);

        return "home";
    }


    @PostMapping("/Address")
    public String submitForm(@ModelAttribute("address") Address address) {
        addressRepository.save(address);
        System.out.println(address);

        return "add_success";
    }

    @PostMapping("/address")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @DeleteMapping("/address/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteAddress(@PathVariable Integer id) {
        addressRepository.deleteById(id);
    }
}
