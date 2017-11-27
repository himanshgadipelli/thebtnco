package com.thebtnco.service;

import com.thebtnco.entity.Language;
import com.thebtnco.entity.Movie;
import com.thebtnco.entity.MovieState;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by NaNi on 11/27/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/thebtnco.xml"
})
@Transactional(readOnly = true)
public class QueryTest {
    @Autowired
    SessionFactory sessionFactory;

    @Test
    @Rollback( value = false)
    public void testCreate() {
        Session session = sessionFactory.openSession();

        Movie movie = new Movie("Bhale Bhale Magadivoy", Language.TELUGU, "NaNi", MovieState.NOT_FOUND);

        session.save(movie);
        session.close();
    }

    @Test
    public void testList(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Movie m ");
        List<Movie> movieList=query.getResultList();
        System.out.println(movieList);
        session.close();
    }
}
