package services/src/main/java/data/repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services/src/main/java/data/domain/SystemLog.java;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
    // You can add custom query methods here if needed
}