package com.thebtnco.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
//    private static final String DEST = "/home/ubuntu/new/";
    private static final String DEST = "D:/home/ubuntu/new/";

    @GetMapping
    public String home() {
        //noinspection SpringMVCViewInspection
        return "home";
    }

}
