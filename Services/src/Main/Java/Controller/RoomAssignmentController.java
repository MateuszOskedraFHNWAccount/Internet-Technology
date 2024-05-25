import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class RoomAssignmentService {

    @PersistenceContext
    private EntityManager entityManager;

    public RoomAssignment createRoomAssignment(RoomAssignment roomAssignment) {
        entityManager.persist(roomAssignment);
        return roomAssignment;
    }

    public RoomAssignment getRoomAssignmentById(int roomID) {
        return entityManager.find(RoomAssignment.class, roomID);
    }

    public List<RoomAssignment> getAllRoomAssignments() {
        return entityManager.createQuery("SELECT ra FROM RoomAssignment ra", RoomAssignment.class)
                .getResultList();
    }

    public RoomAssignment updateRoomAssignment(RoomAssignment roomAssignment) {
        return entityManager.merge(roomAssignment);
    }

    public void deleteRoomAssignment(int roomID) {
        RoomAssignment roomAssignment = entityManager.find(RoomAssignment.class, roomID);
        if (roomAssignment != null) {
            entityManager.remove(roomAssignment);
        }
    }
}