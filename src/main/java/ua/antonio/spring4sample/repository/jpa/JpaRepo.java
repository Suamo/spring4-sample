package ua.antonio.spring4sample.repository.jpa;

import ua.antonio.spring4sample.domain.types.User;

import java.util.List;

public interface JpaRepo {
    void save(User user);

    void truncate();

    List<User> findByAge(int age);
}
