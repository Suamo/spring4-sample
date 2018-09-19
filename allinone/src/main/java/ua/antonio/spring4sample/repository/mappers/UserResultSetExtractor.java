package ua.antonio.spring4sample.repository.mappers;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Useful when multiple rows in the ResultSet map to a single object.
 */
public class UserResultSetExtractor implements ResultSetExtractor<String> {

    @Override
    public String extractData(ResultSet rs) throws SQLException, DataAccessException {

        StringBuilder concat = new StringBuilder();
        while (rs.next()) {
            concat.append(rs.getString("NAME"));
            concat.append(rs.getInt("AGE"));
        }
        return concat.toString();
    }
}