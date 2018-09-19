package ua.antonio.spring4sample.repository.jdbctemplate;

import ua.antonio.spring4sample.domain.types.User;

import java.util.List;

public interface JdbcTemplateRepo {
    void save(User user);
    void truncate();

    List<User> findAll_WithRowMapper();
    List<User> findAll_WithRowCallbackHandler();
    String findAll_WithResultSetExtractor();

    List<User> findByName_WithParameters(String userName);
    List<User> findByName_WithNamedParameters(String userName);

    void createFourUsers(boolean throwExceptionAfterTwo);
    void createFourUsersInTransaction(boolean throwExceptionAfterTwo);

}
