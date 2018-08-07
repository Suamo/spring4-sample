package ua.antonio.spring4sample.repository;

import ua.antonio.spring4sample.domain.types.User;

public interface UserRepo {
    void save(User user);
}
