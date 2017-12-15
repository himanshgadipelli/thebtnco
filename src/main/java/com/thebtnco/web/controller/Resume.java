package com.thebtnco.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by NaNi on 12/14/2017.
 */
@Controller
@RequestMapping("/resume")
public class Resume {
    @GetMapping
    public String resume() {
        //noinspection SpringMVCViewInspection
        return "resume";
    }
}
