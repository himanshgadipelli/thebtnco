package com.thebtnco.web.controller;

import com.thebtnco.persistence.domain.Movie;
import com.thebtnco.persistence.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/api")
public class RESTApiController {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, value = "/view/allMovies")
    public ResponseEntity findAllMovies() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/allMovies")
    public String deleteMovie(@RequestBody Movie movie, RedirectAttributes redirectAttributes) {

        Long id = movie.getId();
        movieService.save(movie);

        // Rerdirect after post to avoid duplicate form submission
        redirectAttributes.addAttribute("id", id);

        return "redirect:plex";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/movie")
    public void editMovie(@RequestBody Movie movie) {
        movieService.editAndSave(movie);
    }
}
