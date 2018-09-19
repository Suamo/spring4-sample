package ua.antonio.spring4sample.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.spring4sample.config.db.JpaH2Config;
import ua.antonio.spring4sample.domain.types.User;
import ua.antonio.spring4sample.repository.jpa.JpaRepo;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.isTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = JpaH2Config.class)
public class JpaTests {

    @Autowired
    private JpaRepo repo;

    @Before
    public void initDb() {
        repo.save(new User("UserName", 17));
    }

    @After
    public void cleanDb() {
        repo.truncate();
    }

    @Test
    public void testRowMapper() {
        User result = repo.findByAge(17).get(0);
        assertEquals(17, result.getAge());

        List<User> retuls1 = repo.findByAge(16);
        isTrue(retuls1.isEmpty());
    }

}
