package ua.antonio.spring4sample.repository;

import com.mysql.jdbc.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.antonio.spring4sample.domain.User;

import javax.sql.DataSource;

public class JdbcUserRepo implements UserRepo {
    public static String DRIVER_NAME = Driver.class.getName();

    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        System.out.println("Saving!");
    }
}
