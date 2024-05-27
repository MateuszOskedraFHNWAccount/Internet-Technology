 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/forumpost")
public class ForumPostController {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;   
    
    @PostMapping(path = "/api/forum/posts",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ForumPost> createForumPost(@RequestBody ForumPost forumPost) {
        ForumPost savedPost = forumPostRepository.save(forumPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }
}