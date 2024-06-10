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
@RequestMapping(path = "/roomassignment")
public class RoomAssignmentController {

    @PostMapping(path = "/api/rooms/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<RoomAssignment> createRoomAssignment(@RequestBody RoomAssignment roomAssignment) {
        RoomAssignment savedAssignment = roomAssignmentRepository.save(roomAssignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAssignment);
    }
}