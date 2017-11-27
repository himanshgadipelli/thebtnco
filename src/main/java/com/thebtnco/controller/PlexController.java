package com.thebtnco.controller;

import com.thebtnco.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by NaNi on 11/16/2017.
 */
@Controller
public class PlexController {
//    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/getAllMoviesRequested", method = RequestMethod.GET)
    public @ResponseBody
    List<Movie> getAllMoviesRequested() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Movie m ");
        List<Movie> movieList = query.getResultList();
        System.out.println(movieList);
        session.close();
        return movieList;
    }

    @RequestMapping(value = "/postFormData", method = RequestMethod.POST)
    public @ResponseBody
    void addMovie(@RequestBody Movie movie) {
        Session session = sessionFactory.openSession();
        session.save(movie);
        session.close();
    }

}
