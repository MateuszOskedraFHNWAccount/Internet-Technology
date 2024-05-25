import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class BuddySystemService {

    @PersistenceContext
    private EntityManager entityManager;

    public BuddySystem createBuddySystem(BuddySystem buddySystem) {
        entityManager.persist(buddySystem);
        return buddySystem;
    }

    public BuddySystem getBuddySystemById(int buddyPairId) {
        return entityManager.find(BuddySystem.class, buddyPairId);
    }

    public List<BuddySystem> getAllBuddySystems() {
        return entityManager.createQuery("SELECT bs FROM BuddySystem bs", BuddySystem.class)
                .getResultList();
    }

    public BuddySystem updateBuddySystem(BuddySystem buddySystem) {
        return entityManager.merge(buddySystem);
    }

    public void deleteBuddySystem(int buddyPairId) {
        BuddySystem buddySystem = entityManager.find(BuddySystem.class, buddyPairId);
        if (buddySystem != null) {
            entityManager.remove(buddySystem);
        }
    }
}