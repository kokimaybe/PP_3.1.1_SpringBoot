package web.PP_31._SpringBoot.DAO;

import org.springframework.stereotype.Repository;
import web.PP_31._SpringBoot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User deleteUser(long id) throws NullPointerException {
        User user = readUser(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }
}
