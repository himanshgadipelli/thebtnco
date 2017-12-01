package com.thebtnco.persistence.service;


import com.thebtnco.persistence.domain.Movie;
import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ady on 2/3/17.
 */
@SuppressWarnings("DefaultFileTemplate")
@Component // Spring component
@Transactional // Annotation driven transaction
public class MovieService {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private SessionFactory sessionFactory;

    public Movie save(Movie movie) {
        // From the factory get a "current" session
        Session session = sessionFactory.getCurrentSession();
        session.setHibernateFlushMode(FlushMode.MANUAL);
        session.saveOrUpdate(movie);
        session.flush();

        return movie;
    }


    public Movie load(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Movie movie = session.load(Movie.class, id);
        Hibernate.initialize(movie);

        return movie;
    }

    public void editAndSave(Movie movie) {
        Movie newMovie = movie;
        newMovie.setId(movie.getId());
        save(newMovie);
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Movie movie = session.load(Movie.class, id);
        session.delete(movie);
    }

    /**
     * @return movieList
     */
    public List<Movie> getAll() {
        Session session = sessionFactory.getCurrentSession();
        //noinspection unchecked
        List<Movie> movieList = session.getNamedQuery("query.loadMovie").list();

        return movieList;
    }


}
