import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutoringSessionRepository extends JpaRepository<TutoringSession, Long> {
    // Add custom query methods here (if needed)
    List<TutoringSession> findBySubjectAndRecurring(String subject, boolean recurring);
}