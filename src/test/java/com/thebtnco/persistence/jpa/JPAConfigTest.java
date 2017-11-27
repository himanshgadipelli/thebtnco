package com.thebtnco.persistence.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by bobby on 10/26/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Multiple locations can be specified with comma delimited values
@ContextConfiguration(locations = {
        "/thebtnco-jpa.xml"
})
@Transactional
public class JPAConfigTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void testConfig() {
        Assert.notNull(entityManager);
    }

}
