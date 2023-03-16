package com.pet.clinic.controller;

import com.pet.clinic.model.Vet;
import com.pet.clinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Slf4j
@Controller
@RequestMapping
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        log.debug("list of vets");
        return "vets/index";
    }

    @GetMapping("/api")
    @ResponseBody
    public ResponseEntity<Set<Vet>> getVets(){
        return ResponseEntity.ok(vetService.findAll());
    }

}
