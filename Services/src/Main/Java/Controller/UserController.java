import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @PostMapping(path = "/api/admin/users/manage",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User user) {
    try {
        entityManager.persist(user);
        return ResponseEntity.ok("User created successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    @PutMapping(path = "/api/admin/users/manage",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser) {
    try {
        User existingUser = userRepository.findById(updatedUser.getId())
        .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + updatedUser.getId()));
        existingUser.setSomeProperty(updatedUser.getSomeProperty());
        userRepository.save(existingUser);
        return ResponseEntity.ok("User updated successfully.");
    } catch (ResourceNotFoundException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    @DeleteMapping(path = "/api/admin/users/manage")
    public ResponseEntity<?> deleteUser(@RequestBody int userID) {
    try {
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    @PosttMapping(path = "/api/auth/login/{studentId}",consumes = "application/json",produces = "application/json")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<User> setRole(@PathVariable("studentId") Long studentId,@RequestParam ERole role) {
        Optional<User> userOptional = userRepository.findById(studentId);
        Optional<Role> roleOptional = roleRepository.findByName(role);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role assignedRole = roleOptional.get();

            user.getRoles().add(assignedRole);
            userRepository.save(user);

            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
}
    public enum ERole {
    ROLE_STUDENT,
    ROLE_SUPERADMIN,
    ROLE_ADMIN
}