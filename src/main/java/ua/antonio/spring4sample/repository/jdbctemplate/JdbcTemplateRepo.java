package ua.antonio.spring4sample.repository.jdbctemplate;

import ua.antonio.spring4sample.domain.types.User;

import java.util.List;
import java.util.Map;

public interface JdbcTemplateRepo {
    void save(User user);
    void truncate();
    List<User> queryWithRowMapper(String sql);
    List<User> queryWithRowCallbackHandler(String sql);
    String queryWithResultSetExtractor(String sql);
    List<User> queryWithParameters(String sql, Object... parameters);
    List<User> queryWithNamedParameters(String sql, Map<String, Object> params);
}
