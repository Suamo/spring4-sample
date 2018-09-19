package ua.antonio.spring4sample.repository.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import ua.antonio.spring4sample.domain.types.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Useful when no query result is expected.
 */
public class UserRowCallbackHandler implements RowCallbackHandler {
    private List<User> list = new ArrayList<>();

    @Override
    public void processRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        int age = rs.getInt("AGE");
        list.add(new User(id, name, age));
    }

    public List<User> getList() {
        return list;
    }
}