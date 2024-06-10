package services/src/main/java/controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/tutoringsession")
public class TutoringSessionController {
    
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
}