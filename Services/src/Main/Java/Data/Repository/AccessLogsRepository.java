import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLogsRepository extends JpaRepository<AccessLogs, Long> {
}