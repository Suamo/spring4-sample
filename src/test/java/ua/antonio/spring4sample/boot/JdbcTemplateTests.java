package ua.antonio.spring4sample.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.spring4sample.config.db.JdbcTemplateConfig;
import ua.antonio.spring4sample.domain.types.User;
import ua.antonio.spring4sample.repository.jdbctemplate.JdbcTemplateRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = JdbcTemplateConfig.class)
public class JdbcTemplateTests {

    @Autowired
    private JdbcTemplateRepo userRepo;

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
        List<User> users = userRepo.findAll_WithRowMapper();
        assertEquals(1, users.size());

        User user = users.get(0);
        assertEquals("UserName", user.getName());
        assertEquals(17, user.getAge());
    }

	@Test
	public void testRowCallbackHandler() {
        List<User> users = userRepo.findAll_WithRowCallbackHandler();
        assertEquals(1, users.size());

        User user = users.get(0);
        assertEquals("UserName", user.getName());
        assertEquals(17, user.getAge());
    }

	@Test
	public void testResultSetExtractor() {
        String concatenatedUsersData = userRepo.findAll_WithResultSetExtractor();
        assertEquals("UserName17", concatenatedUsersData);
    }

	@Test
	public void testParametrizedSearch() {
        List<User> users = userRepo.findByName_WithParameters("UserName");
        assertEquals(1, users.size());

        User user = users.get(0);
        assertEquals("UserName", user.getName());
    }

	@Test
	public void testParametrizedSearch_withNamedParameter() {
        List<User> users = userRepo.findByName_WithNamedParameters("UserName");
        assertEquals(1, users.size());

        User user = users.get(0);
        assertEquals("UserName", user.getName());
    }

}
