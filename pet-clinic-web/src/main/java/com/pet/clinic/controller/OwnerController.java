package com.pet.clinic.controller;

import com.pet.clinic.model.Owner;
import com.pet.clinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/find")
    public String processFindOwners(@ModelAttribute Owner owner, Model model, BindingResult bindingResult) {
        String lastName = owner.getLastName();
        if (StringUtils.isEmpty(lastName)) {
            bindingResult.rejectValue("lastName", "required");
            return "owners/findOwners";
        }
        List<Owner> ownerList = ownerService.findAllByLastName(lastName);
        if (ownerList != null && ownerList.size() == 1) {
            return "redirect:/owners/" + ownerList.get(0).getId();
        } else if (ownerList != null && ownerList.size() > 1) {
            model.addAttribute("owners", ownerList);
            return "owners/owners";
        }
        bindingResult.rejectValue("lastName", "notFound");
        return "owners/findOwners";
    }

    @GetMapping("/find")
    public String find(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public String ownerDetails(@PathVariable Long ownerId, Model model) {
        model.addAttribute("owner", ownerService.findById(ownerId));
        return "owners/details";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/form";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Long id,Model model) {
        model.addAttribute("owner", ownerService.findById(id));
        return "owners/form";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id,@ModelAttribute Owner owner,Model model,BindingResult result) {
        owner.setId(id);
        return create(owner, model, result);
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Owner owner,Model model,BindingResult result){
        if(isNotValid(owner,result)){
            model.addAttribute("owner", owner);
            return "owners/form";
        }
        Owner ownerSaved = ownerService.save(owner);
        return "redirect:/owners/"+ownerSaved.getId();
    }

    private boolean isNotValid(Owner owner, BindingResult result) {
        if(StringUtils.isEmpty(owner.getFirstName())){
            result.rejectValue("firstName","required");
        }
        if(StringUtils.isEmpty(owner.getLastName())){
            result.rejectValue("lastName","required");
        }
        if(StringUtils.isEmpty(owner.getAddress())){
            result.rejectValue("address","required");
        }
        if(StringUtils.isEmpty(owner.getCity())){
            result.rejectValue("city","required");
        }
        if(StringUtils.isEmpty(owner.getMobile())){
            result.rejectValue("mobile","required");
        }
        return result.hasErrors();
    }

}
