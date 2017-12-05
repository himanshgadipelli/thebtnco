package com.thebtnco.persistence.service;

import com.thebtnco.persistence.domain.Movie;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/persistence.xml"})
@Transactional
public class PersistenceServiceTest {

    @Autowired
    private MovieService movieService;


    @Ignore
    public void testInjection() {
        Assert.notNull(movieService);
    }

    @Test
    @Rollback(value = true)
    public void testService() {
        Movie movie = new Movie();
        movie.setName("AAAA");
        movie.setLanguage("Telugu");
        movie.setRequestedBy("NaNi");
        movie.setMovieState("Not on server");
        movieService.save(movie);
    }


    /*@Test
    public void getByCity() {
        List<Person> personList = personService.getAllByCity("Ashburn");

        for (Person p : personList) {
            System.out.println(p.getFirstName());
        }


        List<Person> usingAddressTable = personService.getUsingAddressTable("Ashburn");

        Assert.notEmpty(usingAddressTable);
    }


    @Test
    @Rollback(value = true)

    public void testDelete() {

        personService.delete(1L);

    }*/


}

