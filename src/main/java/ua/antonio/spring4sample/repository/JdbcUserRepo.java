package ua.antonio.spring4sample.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import ua.antonio.spring4sample.domain.User;

import javax.sql.DataSource;

public class JdbcUserRepo implements UserRepo {
    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        System.out.println("Saving!");
    }
}
