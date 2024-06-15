package services.src.main.java.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.src.main.java.data.domain.AccountManagement;
import services.src.main.java.data.repository.AccountManagementRepository;

@Repository
public interface AccountManagementRepository extends JpaRepository<AccountManagement, Long> {

    Object findByActionType(Actiontype actionType);
    // You can add custom query methods here if needed
}