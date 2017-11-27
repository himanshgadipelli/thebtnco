package com.thebtnco.dao;

import com.thebtnco.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by bobby on 11/15/2017.
 */
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Movie movie) {
        em.persist(movie);
    }

    @Override
    public List<Movie> listMovies() {
        CriteriaQuery<Movie> criteriaQuery = em.getCriteriaBuilder().createQuery(Movie.class);

        Root<Movie> root = criteriaQuery.from(Movie.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
