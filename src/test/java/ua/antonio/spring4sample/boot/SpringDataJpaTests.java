package ua.antonio.spring4sample.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import ua.antonio.spring4sample.config.db.SpringDataJpaConfig;
import ua.antonio.spring4sample.domain.types.User;
import ua.antonio.spring4sample.repository.springdatajpa.SpringDataJpaRepo;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SpringDataJpaConfig.class)
public class SpringDataJpaTests {

    @Autowired
    private SpringDataJpaRepo repo;

    @Before
    public void initDb() {
        repo.save(new User("UserName", 17));
    }

    @After
    public void cleanDb() {
        repo.deleteAll();
    }

    @Test
    public void testPremadeFind() {
        List<User> users = repo.findAll();
        assertEquals(1, users.size());

        User user = users.get(0);
        assertEquals("UserName", user.getName());
        assertEquals(17, user.getAge());
    }

    @Test
    public void testCustomFind() {
        User user = repo.findByName("UserName");
        assertEquals(17, user.getAge());

        User user1 = repo.findByName("UserName1");
        Assert.isNull(user1);
    }

}
