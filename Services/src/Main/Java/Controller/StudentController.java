import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/student")
public class StudentService {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(path = "/api/tutoring/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity TutoringSession createTutoringSession(@RequestBody TutoringSession tutoringSession) {
        entityManager.persist(tutoringSession);
        return ResponseEntity tutoringSession;
    }
    @GetMapping(path = "/api/tutoring/search?subject={subject}&recurring={true|false}",produces = "application/json")
    public List<TutoringSession> getAllTutoringSessions() {
        return entityManager.createQuery("SELECT s FROM TutoringSession s",TutoringSession.class)
                .getResultList();
    }
     @PostMapping(path = "/api/projects/mentorship/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity MentoringForProjects createMentoringForProjects(@RequestBody MentoringForProjects mentoringForProjects) {
        entityManager.persist(mentoringForProjects);
        return ResponseEntity mentoringForProjects;
    }
    @GetMapping(path = "/api/projects/mentorship/search?subject={subject}&recurring={true|false}",produces = "application/json")
    public List<MentoringForProjects> getAllMentoringForProjects() {
        return entityManager.createQuery("SELECT mfp FROM MentoringForProjects mfp", MentoringForProjects.class)
                .getResultList();
    }
    @PostMapping(path = "/api/projects/independent",consumes = "application/json",produces = "application/json")
    public ResponseEntity IndependentProject createIndependentProject(@RequestBody IndependentProject independentProject) {
        entityManager.persist(independentProject);
        return ResponseEntity independentProject;
    }
    @PostMapping(path = "/api/buddy/volunteer",consumes = "application/json",produces = "application/json")
    public ResponseEntity BuddySystem createBuddySystem(@RequestBody BuddySystem buddySystem) {
        entityManager.persist(buddySystem);
        return ResponseEntity buddySystem;
    }
    @GetMapping(path = "/api/buddy/match?language={language}",produces = "application/json")
    public List<BuddySystem> getAllBuddySystems() {
        return entityManager.createQuery("SELECT bs FROM BuddySystem bs", BuddySystem.class)
                .getResultList();
    }
    @PostMapping(path = "/api/rooms/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity RoomAssignment createRoomAssignment(@RequestBody RoomAssignment roomAssignment) {
        entityManager.persist(roomAssignment);
        return ResponseEntity roomAssignment;
    }
    @PostMapping(path = "/api/forum/posts",consumes = "application/json",produces = "application/json")
    public ResponseEntity ForumPost createForumPost(@RequestBody ForumPost forumPost) {
        entityManager.persist(forumPost);
        return ResponseEntity forumPost;
    }
    @PostMapping(path = "/api/forum/posts/{postId}/responses",consumes = "application/json",produces = "application/json")
    public ResponseEntity ForumResponse createForumResponse(@PathVariable Long postId,@RequestBody ForumResponse forumResponse) {
        entityManager.persist(postId,forumResponse);
        return ResponseEntity forumResponse;
    }
}

