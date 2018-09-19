package ua.antonio.spring4sample.service;

import ua.antonio.spring4sample.domain.types.User;
import ua.antonio.spring4sample.repository.jdbctemplate.JdbcTemplateRepo;

public class SimpleUserService implements UserService {
    private JdbcTemplateRepo userRepo;

    public SimpleUserService(JdbcTemplateRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
