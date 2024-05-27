import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/mentoringforprojects")
public class MentoringForProjectsController {

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
}