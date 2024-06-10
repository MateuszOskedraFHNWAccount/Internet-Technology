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
@RequestMapping(path = "/independentproject")
public class IndependentProjectController {

    @PostMapping(path = "/api/projects/independent",consumes = "application/json",produces = "application/json")
    public ResponseEntity<IndependentProject> createIndependentProject(@RequestBody IndependentProject independentProject) {
        IndependentProject savedProject = independentProjectRepository.save(independentProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }
}