import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoringForProjectsRepository extends JpaRepository<MentoringForProjects, Long> {
    // You can add custom query methods here if needed
}