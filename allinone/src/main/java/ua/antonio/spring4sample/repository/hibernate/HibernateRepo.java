package ua.antonio.spring4sample.repository.hibernate;

import ua.antonio.spring4sample.domain.types.User;

import java.util.List;

public interface HibernateRepo {

    void save(User user);

    List<User> findAll();

    void truncate();

    void createFourUsers(boolean throwExceptionAfterTwo);

    void createFourUsersInTransaction(boolean throwExceptionAfterTwo);
}
