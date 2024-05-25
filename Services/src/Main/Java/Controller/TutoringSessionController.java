import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class TutoringSessionService {

    @PersistenceContext
    private EntityManager entityManager;

    public TutoringSession createTutoringSession(TutoringSession tutoringSession) {
        entityManager.persist(tutoringSession);
        return tutoringSession;
    }

    public TutoringSession getTutoringSessionById(int sessionID) {
        return entityManager.find(TutoringSession.class, sessionID);
    }

    public List<TutoringSession> getAllTutoringSessions() {
        return entityManager.createQuery("SELECT ts FROM TutoringSession ts", TutoringSession.class)
                .getResultList();
    }

    public TutoringSession updateTutoringSession(TutoringSession tutoringSession) {
        return entityManager.merge(tutoringSession);
    }

    public void deleteTutoringSession(int sessionID) {
        TutoringSession tutoringSession = entityManager.find(TutoringSession.class, sessionID);
        if (tutoringSession != null) {
            entityManager.remove(tutoringSession);
        }
    }
}