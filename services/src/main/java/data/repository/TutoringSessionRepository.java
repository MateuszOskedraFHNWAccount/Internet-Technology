package data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import data.domain.TutoringSession;
import data.repository.TutoringSessionRepository;

@Repository
public interface TutoringSessionRepository extends JpaRepository<TutoringSession, Long> {
    // Add custom query methods here (if needed)
    List<TutoringSession> findBySubjectAndRecurring(String subject, boolean recurring);

    Object findBySubject(String subject);
}