package com.thebtnco.service;

import com.thebtnco.entity.Movie;

import java.util.List;

/**
 * Created by bobby on 10/26/2017.
 */

public interface MovieService {
    void add(Movie movie);
    List<Movie> listMovies();
}
