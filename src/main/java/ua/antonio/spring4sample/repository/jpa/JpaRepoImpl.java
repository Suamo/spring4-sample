package ua.antonio.spring4sample.repository.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.antonio.spring4sample.domain.types.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class JpaRepoImpl implements JpaRepo {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void truncate() {
        entityManager.createNativeQuery("delete from USERS").executeUpdate();
    }

    @Override
    public List<User> findByAge(int age){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot);
        criteria.where(builder.equal(userRoot.get("age"), age));

        return entityManager.createQuery(criteria).getResultList();
    }

}
