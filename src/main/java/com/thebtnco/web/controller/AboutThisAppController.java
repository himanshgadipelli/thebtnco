package com.thebtnco.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aboutThisApp")
public class AboutThisAppController {

    @GetMapping
    public String aboutThisApp() {

        return "about-this-app";
    }
}