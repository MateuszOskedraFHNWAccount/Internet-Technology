import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomAssignmentRepository extends JpaRepository<RoomAssignment, Long> {
    // You can add custom query methods here if needed
}