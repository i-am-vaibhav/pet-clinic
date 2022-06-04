package com.pet.clinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @GetMapping({"", "/", "index.html", "index"})
    public String index(Model model) {
        log.debug("index page");
        return "index";
    }


    @GetMapping("/oups")
    public String oups() {
        return "notImplemented";
    }

}
