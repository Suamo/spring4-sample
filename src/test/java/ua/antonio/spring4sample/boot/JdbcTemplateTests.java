package ua.antonio.spring4sample.boot;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.antonio.spring4sample.boot.mappers.UserResultSetExtractor;
import ua.antonio.spring4sample.boot.mappers.UserRowCallbackHandler;
import ua.antonio.spring4sample.boot.mappers.UserRowMapper;
import ua.antonio.spring4sample.config.db.JdbcTemplateConfig;
import ua.antonio.spring4sample.domain.types.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = JdbcTemplateConfig.class)
public class JdbcTemplateTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate jdbcNamedTemplate;

    @Before
    public void initDb() {
        jdbcTemplate.update("INSERT INTO USERS (NAME, AGE) VALUES (?, ?);", "UserName", 17);
    }

    @After
    public void cleanDb() {
        jdbcTemplate.update("TRUNCATE TABLE USERS;");
    }

	@Test
	public void testRowMapper() {
        User user = jdbcTemplate.queryForObject("SELECT * FROM USERS", new UserRowMapper());

        assertEquals("UserName", user.getName());
        assertEquals(17, user.getAge());
    }

	@Test
	public void testRowCallbackHandler() {
        UserRowCallbackHandler rch = new UserRowCallbackHandler();
        jdbcTemplate.query("SELECT * FROM USERS", rch);
        List<User> result = rch.getList();

        assertEquals(1, result.size());
        User user = result.get(0);
        assertEquals("UserName", user.getName());
        assertEquals(17, user.getAge());
    }

	@Test
	public void testResultSetExtractor() {
        String result = jdbcTemplate.query("SELECT * FROM USERS", new UserResultSetExtractor());
        assertEquals("UserName17", result);
    }

	@Test
	public void testParametrizedSearch() {
        String sql = "SELECT * FROM USERS where NAME = ?";
        User result = jdbcTemplate.queryForObject(sql, new UserRowMapper(), "UserName");

        assertEquals("UserName", result.getName());
    }

	@Test
	public void testParametrizedSearch_withNamedParameter() {
        String sql = "SELECT * FROM USERS where NAME = :name";
        Map<String, Object> params = new HashMap<>();
        params.put("name", "UserName");

        User result = jdbcNamedTemplate.queryForObject(sql, params, new UserRowMapper());

        assertEquals("UserName", result.getName());
    }

}
