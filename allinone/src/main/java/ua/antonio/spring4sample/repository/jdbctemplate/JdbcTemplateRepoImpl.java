package ua.antonio.spring4sample.repository.jdbctemplate;

import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.antonio.spring4sample.domain.types.User;
import ua.antonio.spring4sample.repository.mappers.UserResultSetExtractor;
import ua.antonio.spring4sample.repository.mappers.UserRowCallbackHandler;
import ua.antonio.spring4sample.repository.mappers.UserRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateRepoImpl implements JdbcTemplateRepo {
    public static final String DRIVER_NAME = Driver.class.getName();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate jdbcNamedTemplate;

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO USERS (NAME, AGE) VALUES (?, ?);", user.getName(), user.getAge());
    }

    @Override
    public void truncate() {
        jdbcTemplate.update("TRUNCATE TABLE USERS;");
    }

    @Override
    public List<User> findAll_WithRowMapper() {
        return jdbcTemplate.query("SELECT * FROM USERS", new UserRowMapper());
    }

    @Override
    public List<User> findAll_WithRowCallbackHandler() {
        UserRowCallbackHandler rch = new UserRowCallbackHandler();
        jdbcTemplate.query("SELECT * FROM USERS", rch);
        return rch.getList();
    }

    @Override
    public String findAll_WithResultSetExtractor() {
        return jdbcTemplate.query("SELECT * FROM USERS", new UserResultSetExtractor());
    }

    @Override
    public List<User> findByName_WithParameters(String userName) {
        return jdbcTemplate.query("SELECT * FROM USERS where NAME = ?", new UserRowMapper(), userName);
    }

    @Override
    public List<User> findByName_WithNamedParameters(String userName) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", userName);
        return jdbcNamedTemplate.query("SELECT * FROM USERS where NAME = :name", params, new UserRowMapper());
    }

    @Override
    public void createFourUsers(boolean throwExceptionAfterTwo) {
        save(new User("User1", 15));
        save(new User("User1", 15));
        if (throwExceptionAfterTwo)
            throw new RuntimeException("Exception in the middle of Repository method");
        save(new User("User1", 15));
        save(new User("User1", 15));
    }

    @Override
    @Transactional
    public void createFourUsersInTransaction(boolean throwExceptionAfterTwo) {
        createFourUsers(throwExceptionAfterTwo);
    }
}
