package com.pet.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    @GetMapping({"/vets","/vets/index","/vets/index.html"})
    public String listVets(Model model){
     return "vets/index";
    }
}
