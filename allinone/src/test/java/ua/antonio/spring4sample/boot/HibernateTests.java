package ua.antonio.spring4sample.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.spring4sample.config.db.HibernateH2Config;
import ua.antonio.spring4sample.domain.types.User;
import ua.antonio.spring4sample.repository.hibernate.HibernateRepo;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = HibernateH2Config.class)
public class HibernateTests {

    @Autowired
    private HibernateRepo repo;

    @Before
    public void initDb() {
        repo.save(new User(1, "UserName", 17));
    }

    @After
    public void cleanDb() {
        repo.truncate();
    }

    @Test
    public void testRowMapper() {
        List<User> users = repo.findAll();
        assertEquals(1, users.size());

        User user = users.get(0);
        assertEquals("UserName", user.getName());
        assertEquals(17, user.getAge());
    }


    @Test
    @Ignore("Cannot figure out how to turn off transaction support. SpringSessionContext.currentSession is failing with" +
            "'Could not obtain transaction-synchronized Session for current thread'")
    public void testNonTransactionalBehavior() {
        cleanDb();
        assertEquals(0, repo.findAll().size());

        try {
            repo.createFourUsers(true);
        } catch (RuntimeException e){}
        assertEquals(2, repo.findAll().size());
    }

    @Test
    public void testTransactionalBehavior() {
        cleanDb();
        assertEquals(0, repo.findAll().size());

        try {
            repo.createFourUsersInTransaction(true);
        } catch (RuntimeException e){}
        assertEquals(0, repo.findAll().size());
    }
}
