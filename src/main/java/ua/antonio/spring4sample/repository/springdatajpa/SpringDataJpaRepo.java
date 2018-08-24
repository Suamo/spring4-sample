package ua.antonio.spring4sample.repository.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.antonio.spring4sample.domain.types.User;

@Repository
public interface SpringDataJpaRepo extends JpaRepository<User, Integer> {

    User findByAge(int age);

}
