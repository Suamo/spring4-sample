package ua.antonio.spring4sample.boot.mappers;

import org.springframework.jdbc.core.RowMapper;
import ua.antonio.spring4sample.domain.types.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        int age = rs.getInt("AGE");
        return new User(id, name, age);
    }

}
