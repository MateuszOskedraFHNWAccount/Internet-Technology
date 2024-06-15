package services.src.main.java.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.src.main.java.data.domain.TutoringSession;
import services.src.main.java.data.repository.TutoringSessionRepository;

@Repository
public interface TutoringSessionRepository extends JpaRepository<TutoringSession, Long> {
    // Add custom query methods here (if needed)
    List<TutoringSession> findBySubjectAndRecurring(String subject, boolean recurring);

    Object findBySubject(String subject);
}