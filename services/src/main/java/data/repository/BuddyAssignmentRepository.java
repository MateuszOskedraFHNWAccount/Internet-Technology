package data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import data.domain.BuddyAssignment;
import data.repository.BuddyAssignmentRepository;

@Repository
public interface BuddyAssignmentRepository extends JpaRepository<BuddyAssignment, Long> {

    boolean assignbuddy(String string, long getbuddyId);
    // You can add custom query methods here if needed

    Object findByinternationalstudentId(String getinternationalstudentId);
}