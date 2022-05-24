package com.pet.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"", "/", "index.html", "index"})
    public String index(Model model) {
        model.addAttribute("msg", "Hello guys");
        return "index";
    }

}
