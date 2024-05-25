import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ForumPostService {

    @PersistenceContext
    private EntityManager entityManager;

    public ForumPost createForumPost(ForumPost forumPost) {
        entityManager.persist(forumPost);
        return forumPost;
    }

    public ForumPost getForumPostById(int postId) {
        return entityManager.find(ForumPost.class, postId);
    }

    public List<ForumPost> getAllForumPosts() {
        return entityManager.createQuery("SELECT fp FROM ForumPost fp", ForumPost.class)
                .getResultList();
    }

    public ForumPost updateForumPost(ForumPost forumPost) {
        return entityManager.merge(forumPost);
    }

    public void deleteForumPost(int postId) {
        ForumPost forumPost = entityManager.find(ForumPost.class, postId);
        if (forumPost != null) {
            entityManager.remove(forumPost);
        }
    }
}