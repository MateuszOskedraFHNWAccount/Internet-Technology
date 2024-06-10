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
@RequestMapping(path = "/jobadvertisement")
public class JobAdvertisementController {

    @PostMapping(path = "/api/admin/jobs",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
    try {
        entityManager.persist(jobAdvertisement);
        return ResponseEntity.ok("Job advertisement created successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping(path = "/api/admin/advertisements".consumes = "application/json",produces = "application/json")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAdvertisement = advertisementService.saveAdvertisement(advertisement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdvertisement);
    }
}