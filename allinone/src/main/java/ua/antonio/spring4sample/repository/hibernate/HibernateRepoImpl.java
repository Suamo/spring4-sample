package ua.antonio.spring4sample.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.antonio.spring4sample.domain.types.User;

import java.util.List;

@Repository
@Transactional
public class HibernateRepoImpl implements HibernateRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        session().save(user);
    }

    @Override
    public List<User> findAll() {
        return session().createQuery("from User").list();
    }

    @Override
    public void truncate() {
        session().createQuery("delete from User").executeUpdate();
    }

    @Override
    public void createFourUsers(boolean throwExceptionAfterTwo) {
        save(new User("User1", 15));
        save(new User("User1", 15));
        if (throwExceptionAfterTwo)
            throw new RuntimeException("Exception in the middle of Repository method");
        save(new User("User1", 15));
        save(new User("User1", 15));
    }

    @Override
    public void createFourUsersInTransaction(boolean throwExceptionAfterTwo) {
        createFourUsers(throwExceptionAfterTwo);
    }

}
