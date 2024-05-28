import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/accountmanagement")
public class AccountManagementController {

    @PutMapping(path = "/api/superadmin/admins/update/{adminId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateAccountManagement(@PathVariable Long adminId, @RequestBody AccountManagement updatedAccount) {
    try {
        AccountManagement existingAccount = accountManagementRepository.findById(adminId)
        .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + adminId));
        existingAccount.setSomeProperty(updatedAccount.getSomeProperty());
        AccountManagement savedAccount = accountManagementRepository.save(existingAccount);
        return ResponseEntity.ok(savedAccount);
    } catch (ResourceNotFoundException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    @DeleteMapping(path = "/api/superadmin/admins/delete/{adminId}")
    public ResponseEntity<?> deleteAccountManagement(@PathVariable Long adminId) {
    try {
        Optional<AccountManagement> optionalAccount = accountManagementRepository.findById(adminId);
        if (optionalAccount.isPresent()) {
            AccountManagement accountManagement = optionalAccount.get();
            accountManagementRepository.delete(accountManagement);
            return ResponseEntity.ok("Account management record deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting account management record.");
    }
}
    @PostMapping(path = "/api/superadmin/admins/create",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createAccountManagement(@RequestBody AccountManagement accountManagement) {
    try {
        AccountManagement savedAccount = accountManagementRepository.save(accountManagement);
        return ResponseEntity.ok("Account management record created successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    @PostMapping(path = "/api/auth/login/{superadminId}",consumes = "application/json",produces = "application/json")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<User> setRole(@PathVariable("superadminId") Long superadminId,@RequestParam ERole role) {
        Optional<User> userOptional = userRepository.findById(superadminId);
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