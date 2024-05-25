import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ForumResponseService {

    @PersistenceContext
    private EntityManager entityManager;

    public ForumResponse createForumResponse(ForumResponse forumResponse) {
        entityManager.persist(forumResponse);
        return forumResponse;
    }

    public ForumResponse getForumResponseById(int responseId) {
        return entityManager.find(ForumResponse.class, responseId);
    }

    public List<ForumResponse> getAllForumResponses() {
        return entityManager.createQuery("SELECT fr FROM ForumResponse fr", ForumResponse.class)
                .getResultList();
    }

    public ForumResponse updateForumResponse(ForumResponse forumResponse) {
        return entityManager.merge(forumResponse);
    }

    public void deleteForumResponse(int responseId) {
        ForumResponse forumResponse = entityManager.find(ForumResponse.class, responseId);
        if (forumResponse != null) {
            entityManager.remove(forumResponse);
        }
    }
}