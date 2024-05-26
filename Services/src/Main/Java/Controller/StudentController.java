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
public class StudentController {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(path = "/api/tutoring/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity<TutoringSession> createTutoringSession(@RequestBody TutoringSession tutoringSession) {
        TutoringSession savedSession = tutoringSessionRepository.save(tutoringSession);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSession);
}
    @GetMapping(path = "/api/tutoring/search?subject={subject}&recurring={true|false}",produces = "application/json")
    public ResponseEntity<List<TutoringSession>> getAllTutoringSessions(@RequestParam(name = "subject") String subject,
        @RequestParam(name = "recurring", defaultValue = "false") boolean recurring) {
        List<TutoringSession> tutoringSessions = tutoringSessionRepository.findBySubjectAndRecurring(subject, recurring);
        return ResponseEntity.ok(tutoringSessions);
}
    @PostMapping(path = "/api/projects/mentorship/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity<MentoringForProjects> createMentoringForProjects(@RequestBody MentoringForProjects mentoringForProjects) {
        MentoringForProjects savedMentoring = mentoringRepository.save(mentoringForProjects);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMentoring);
}
    @GetMapping(path = "/api/projects/mentorship/search?subject={subject}&recurring={true|false}", produces = "application/json")
    public ResponseEntity<List<MentoringForProjects>> getAllMentoringForProjects() {
        List<MentoringForProjects> mentoringList = mentoringRepository.findAll();
        return ResponseEntity.ok(mentoringList);
}
    @PostMapping(path = "/api/projects/independent",consumes = "application/json",produces = "application/json")
    public ResponseEntity<IndependentProject> createIndependentProject(@RequestBody IndependentProject independentProject) {
        IndependentProject savedProject = independentProjectRepository.save(independentProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
}
    @PostMapping(path = "/api/buddy/volunteer",consumes = "application/json",produces = "application/json")
    public ResponseEntity<BuddySystem> createBuddySystem(@RequestBody BuddySystem buddySystem) {
        BuddySystem savedBuddySystem = buddySystemRepository.save(buddySystem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuddySystem);
}
    @GetMapping(path = "/api/buddy/match?language={language}",produces = "application/json")
    public ResponseEntity<List<BuddySystem>> getAllBuddySystems(@RequestParam(name = "language") String language) {
        List<BuddySystem> buddySystems = buddySystemRepository.findByLanguage(language);
        return ResponseEntity.ok(buddySystems);
}
    @PostMapping(path = "/api/rooms/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<RoomAssignment> createRoomAssignment(@RequestBody RoomAssignment roomAssignment) {
        RoomAssignment savedAssignment = roomAssignmentRepository.save(roomAssignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAssignment);
}
    @PostMapping(path = "/api/forum/posts",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ForumPost> createForumPost(@RequestBody ForumPost forumPost) {
        ForumPost savedPost = forumPostRepository.save(forumPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
}
    @PostMapping(path = "/api/forum/posts/{postId}/responses", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ForumResponse> createForumResponse(@PathVariable Long postId, @RequestBody ForumResponse forumResponse) {
        forumResponse.setPostId(postId);
        ForumResponse savedResponse = forumResponseRepository.save(forumResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResponse);
}
    @PostMapping(path = "/api/auth/login/{studentId}",consumes = "application/json",produces = "application/json")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<User> setRole(@PathVariable("studentId") Long studentId,@RequestParam ERole role) {
        Optional<User> userOptional = userRepository.findById(studentId);
        Optional<Role> roleOptional = roleRepository.findByName(role);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role assignedRole = roleOptional.get();

            user.getRoles().add(assignedRole);
            userRepository.save(user);

            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public enum ERole {
    ROLE_STUDENT,
    ROLE_SUPERADMIN,
    ROLE_ADMIN
    }
}