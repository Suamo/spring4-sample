package ua.antonio.spring4sample.repository;

import ua.antonio.spring4sample.domain.User;

public interface UserRepo {
    void save(User user);
}
