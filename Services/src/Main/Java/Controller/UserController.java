import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public User getUserById(int userID) {
        return entityManager.find(User.class, userID);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    public void deleteUser(int userID) {
        User user = entityManager.find(User.class, userID);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}