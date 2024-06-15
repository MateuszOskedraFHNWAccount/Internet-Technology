package services.src.main.java.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.src.main.java.data.domain.AdminActions;
import services.src.main.java.data.domain.User;

@Repository
public interface AdminActionsRepository extends JpaRepository<AdminActions, Long> {

    User findById(long actionID);
    // You can add custom query methods here if needed

    AdminActions save(AdminActions existingAction);
}