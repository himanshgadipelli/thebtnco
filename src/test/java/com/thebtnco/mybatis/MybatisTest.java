package com.thebtnco.mybatis;/*
package com.thebtnco.mybatis;

import com.thebtnco.mybatis.mapper.MovieMapper;
import com.thebtnco.mybatis.mapper.PersonMapper;
import com.thebtnco.mybatis.mapper.SearchCriteria;
import com.thebtnco.persistence.domain.Movie;
import com.thebtnco.persistence.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

*/
/*
  Created by Ady on 2/14/17.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mybatis.xml"})
@Transactional
public class MybatisTest {

    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void testMapper() {
        Assert.notNull(movieMapper);
    }

    @Test
    public void getPerson() {
        List<Movie> movieList = movieMapper.getMovieList();
        System.out.println(movieList.size());
    }

    @Test
    public void search() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setLastName("Vashisht".toLowerCase());
        //List<Person> personList = personMapper.search(criteria);
        //System.out.println(personList.size());
    }
}
*/
