package com.thebtnco.dao;

import com.thebtnco.entity.Movie;

import java.util.List;

/**
 * Created by bobby on 11/15/2017.
 */
public interface MovieDao {
    void add (Movie movie);
    List<Movie> listMovies();
}
