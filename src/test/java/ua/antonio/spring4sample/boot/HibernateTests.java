package ua.antonio.spring4sample.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.spring4sample.config.db.HibernateH2Config;
import ua.antonio.spring4sample.domain.types.User;
import ua.antonio.spring4sample.repository.UserRepo;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = HibernateH2Config.class)
public class HibernateTests {

    @Autowired
    private UserRepo userRepo;

    @Before
    public void initDb() {
        userRepo.save(new User("UserName", 17));
    }

    @After
    public void cleanDb() {
        userRepo.truncate();
    }

	@Test
	public void testRowMapper() {
        List<User> users = userRepo.queryWithRowMapper("SELECT * FROM USERS");
        assertEquals(1, users.size());

        User user = users.get(0);
        assertEquals("UserName", user.getName());
        assertEquals(17, user.getAge());
    }

}
