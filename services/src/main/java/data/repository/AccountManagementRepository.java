package services/src/main/java/data/repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountManagementRepository extends JpaRepository<AccountManagement, Long> {
    // You can add custom query methods here if needed
}