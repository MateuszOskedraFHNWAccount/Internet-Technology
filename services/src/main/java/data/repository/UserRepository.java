package data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import data.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Object findByUsername(String username);
    // Custom query methods can be defined here
    // For example:
    // List<User> findBySomeProperty(String someProperty);
}