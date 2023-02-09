package com.pet.clinic.controller;

import com.pet.clinic.model.Owner;
import com.pet.clinic.model.Pet;
import com.pet.clinic.model.PetType;
import com.pet.clinic.services.OwnerService;
import com.pet.clinic.services.PetService;
import com.pet.clinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final PetService petService;

    public PetController(PetTypeService petTypeService, OwnerService ownerService, PetService petService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @ModelAttribute("types")
    public List<PetType> getPetTypes() {
        return petTypeService.findAll().stream().collect(Collectors.toList());
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void webDataBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/create")
    public String createPetPage(@PathVariable Long ownerId, Model model) {
        model.addAttribute("pet", new Pet());
        return "pets/form";
    }

    @GetMapping("/pets/{petId}/update")
    public String updatePetPage(@PathVariable Long ownerId, @PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return "pets/form";
    }

    @PostMapping("/pets/{petId}/update")
    public String update(@ModelAttribute Owner owner, @ModelAttribute Pet pet, @PathVariable Long petId, Model model, BindingResult result) {
        pet.setId(petId);
        String invalidRes = createOrUpdate(owner, pet, model, result);
        if (invalidRes != null) return invalidRes;
        return "redirect:/owners/" + owner.getId();
    }

    @PostMapping("/pets/create")
    public String create(@ModelAttribute Owner owner, @ModelAttribute Pet pet, Model model, BindingResult result) {
        String invalidRes = createOrUpdate(owner, pet, model, result);
        if (invalidRes != null) return invalidRes;
        return "redirect:/owners/" + owner.getId();
    }

    private String createOrUpdate(Owner owner, Pet pet, Model model, BindingResult result) {
        if (isNotValid(pet, result)) {
            model.addAttribute("pet", pet);
            return "pets/form";
        }
        Set<Pet> pets = owner.getPets();
        if (pet.getId() == null & pets.stream().anyMatch(aPet -> aPet.getName().equalsIgnoreCase(pet.getName()))) {
            model.addAttribute("pet", pet);
            result.rejectValue("name", "duplicate");
            return "pets/form";
        }
        // To do creating a formatter
        //PetType type = getPetTypes().stream().filter(p -> p.getName().equals(pet.getType().getName())).findFirst().orElse(null);
        if (pet.getType() == null) {
            model.addAttribute("pet", pet);
            result.rejectValue("type.name", "notFound");
            return "pets/form";
        }
        pet.setType(pet.getType());
        pet.setOwner(owner);
        petService.save(pet);
        return null;
    }

    private boolean isNotValid(Pet pet, BindingResult result) {
        if (StringUtils.isEmpty(pet.getName())) {
            result.rejectValue("name", "required");
        }
        if (pet.getBirthDate() == null) {
            result.rejectValue("birthDate", "required");
        }
        if (StringUtils.isEmpty(pet.getType().toString())) {
            result.rejectValue("type", "required");
        }
        return result.hasErrors();
    }

}
