package com.thebtnco.service;

import com.thebtnco.dao.MovieDao;
import com.thebtnco.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bobby on 11/15/2017.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Transactional
    @Override
    public void add(Movie movie) {
        movieDao.add(movie);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Movie> listMovies() {
        return movieDao.listMovies();
    }
}
