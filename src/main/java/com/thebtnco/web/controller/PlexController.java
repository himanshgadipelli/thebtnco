package com.thebtnco.web.controller;

import com.thebtnco.persistence.domain.Movie;
import com.thebtnco.persistence.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plex")
public class PlexController {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String movie() {
        //noinspection SpringMVCViewInspection
        return "plex";
    }

    @PostMapping
    public String save(@RequestBody Movie movie) {

        movieService.save(movie);
        return "redirect:plex";
    }

}