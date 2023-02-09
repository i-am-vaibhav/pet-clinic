package com.pet.clinic.controller;

import com.pet.clinic.model.Pet;
import com.pet.clinic.model.Visit;
import com.pet.clinic.services.PetService;
import com.pet.clinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners/{ownerId}/pets/{petId}")
public class VisitControlller {

    private final VisitService visitService;
    private final PetService petService;


    public VisitControlller(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @ModelAttribute("visit")
    public Visit getVisit(@PathVariable Long petId, Model model) {
        Pet pet = petService.findById(petId);
        Visit visit = new Visit();
        model.addAttribute("pet", pet);
        return visit;
    }

    @GetMapping("/visits")
    public String createPage(Model model) {
        return "visits/form";
    }

    @PostMapping("/visits")
    public String createVisit(@ModelAttribute Pet pet, @ModelAttribute Visit visit, Model model, BindingResult result) {
        if (isNotValid(visit, result)) {
            model.addAttribute("pet", pet);
            model.addAttribute("visit", visit);
            return "visits/form";
        }
        visit.setPet(pet);
        visitService.save(visit);
        return "redirect:/owners/" + pet.getOwner().getId();
    }

    private boolean isNotValid(Visit visit, BindingResult result) {
        if (StringUtils.isEmpty(visit.getDescription())) {
            result.rejectValue("visitDate", "required");
        }
        if (visit.getVisitDate() == null) {
            result.rejectValue("description", "required");
        }
        return result.hasErrors();
    }

}
