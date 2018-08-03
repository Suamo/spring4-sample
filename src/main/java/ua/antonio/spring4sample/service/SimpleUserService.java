package ua.antonio.spring4sample.service;

import ua.antonio.spring4sample.domain.User;
import ua.antonio.spring4sample.repository.UserRepo;

public class SimpleUserService implements UserService {
    private UserRepo userRepo;

    public SimpleUserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
