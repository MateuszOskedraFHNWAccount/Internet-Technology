import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/forumresponse")
public class ForumResponseController {

    @PostMapping(path = "/api/forum/posts/{postId}/responses", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ForumResponse> createForumResponse(@PathVariable Long postId, @RequestBody ForumResponse forumResponse) {
        forumResponse.setPostId(postId);
        ForumResponse savedResponse = forumResponseRepository.save(forumResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResponse);
    }
}