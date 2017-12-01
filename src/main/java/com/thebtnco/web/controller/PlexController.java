package com.thebtnco.web.controller;

import com.thebtnco.persistence.domain.Movie;
import com.thebtnco.persistence.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/plex")
public class PlexController {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String movie(Model model, @RequestParam(value = "id", required = false) Long id) {

        //noinspection SpringMVCViewInspection
        return "plex";// /WEB-INF/views/home.jsp"
    }

    @PostMapping
    public String save(@RequestBody Movie movie, RedirectAttributes redirectAttributes) {

        movie = movieService.save(movie);
        Long id = movie.getId();

        // Rerdirect after post to avoid duplicate form submission
        redirectAttributes.addAttribute("id", id);

        return "redirect:plex";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/movie")
    public void editMovie(@RequestBody Movie movie) {
        movieService.editAndSave(movie);
    }

}