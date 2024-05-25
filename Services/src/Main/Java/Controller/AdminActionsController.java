import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class AdminActionsService {

    @PersistenceContext
    private EntityManager entityManager;

    public AdminActions createAdminAction(AdminActions adminAction) {
        entityManager.persist(adminAction);
        return adminAction;
    }

    public AdminActions getAdminActionById(int actionId) {
        return entityManager.find(AdminActions.class, actionId);
    }

    public List<AdminActions> getAllAdminActions() {
        return entityManager.createQuery("SELECT aa FROM AdminActions aa", AdminActions.class)
                .getResultList();
    }

    public AdminActions updateAdminAction(AdminActions adminAction) {
        return entityManager.merge(adminAction);
    }

    public void deleteAdminAction(int actionId) {
        AdminActions adminAction = entityManager.find(AdminActions.class, actionId);
        if (adminAction != null) {
            entityManager.remove(adminAction);
        }
    }
}