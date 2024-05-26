import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/adminactions")
public class AdminActionsService {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @PutMapping(path = "/api/admin/modify/{type}/{id}",consumes = "application/json",produces = "application/json")
    public ResponseEntity AdminActions updateAdminAction(@RequestBody Actiontype type,@PathVariable Long id,@RequestBody AdminActions adminAction) {
        return entityManager.merge(ResponseEntity type,ResponseEntity id,ResponseEntity adminAction);
    }
    @DeleteMapping(path = "/api/admin/delete/{type}/{id}")
    public void ResponseEntity deleteAdminAction(@RequestBody Actiontype type,@PahtVariable int Id) {
        AdminActions adminAction = entityManager.find(AdminActions.class,type,Id);
        if (adminAction != null) {
            entityManager.remove(ResponseEntity adminAction);
    }
    @GetMapping(path = "/api/admin/logs",produces = "application/json")
    public List<SystemLog> getAllSystemLogs() {
        return entityManager.createQuery("SELECT sl FROM SystemLog sl", SystemLog.class)
                .getResultList();
    }
    @PostMapping(path = "/api/admin/advertisements".consumes = "application/json",produces = "application/json")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAdvertisement = advertisementService.saveAdvertisement(advertisement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdvertisement);
    }
    @PostMapping(value = "/api/admin/buddy/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> assignBuddyToInternationalStudent(@RequestBody BuddyAssignmentRequest request) {
        boolean assignmentSuccessful = buddyAssignmentService.assignBuddy(request.getInternationalStudentId(), request.getBuddyId());
        if (assignmentSuccessful) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Buddy assigned successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to assign buddy.");
        }
    }
}