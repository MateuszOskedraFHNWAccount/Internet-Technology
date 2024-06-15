package data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import data.domain.AdminActions;
import data.domain.User;

@Repository
public interface AdminActionsRepository extends JpaRepository<AdminActions, Long> {

    User findById(long actionID);
    // You can add custom query methods here if needed

    @SuppressWarnings({ "null", "unchecked" })
    AdminActions save(AdminActions existingAction);
}