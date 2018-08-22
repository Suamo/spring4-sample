package ua.antonio.spring4sample.repository.jdbctemplate;

import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.antonio.spring4sample.domain.types.User;
import ua.antonio.spring4sample.repository.mappers.UserResultSetExtractor;
import ua.antonio.spring4sample.repository.mappers.UserRowCallbackHandler;
import ua.antonio.spring4sample.repository.mappers.UserRowMapper;

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
    public List<User> queryWithRowMapper(String sql) {
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public List<User> queryWithRowCallbackHandler(String sql) {
        UserRowCallbackHandler rch = new UserRowCallbackHandler();
        jdbcTemplate.query(sql, rch);
        return rch.getList();
    }

    @Override
    public String queryWithResultSetExtractor(String sql) {
        return jdbcTemplate.query(sql, new UserResultSetExtractor());
    }

    @Override
    public List<User> queryWithParameters(String sql, Object... parameters) {
        return jdbcTemplate.query(sql, new UserRowMapper(), parameters);
    }

    @Override
    public List<User> queryWithNamedParameters(String sql, Map<String, Object> params) {
        return jdbcNamedTemplate.query(sql, params, new UserRowMapper());
    }
}
