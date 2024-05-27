import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/adminactions")
public class AdminActionsController {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;    
    
    @PutMapping(path = "/api/admin/modify/{type}/{id}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<AdminActions> updateAdminAction(@PathVariable String type, @PathVariable Long id, @RequestBody AdminActions adminAction) {
        AdminActions existingAction = adminActionsRepository.findById(id).orElse(null);
        if (existingAction != null) {
            existingAction.setType(type);
            AdminActions updatedAction = adminActionsRepository.save(existingAction);
            return ResponseEntity.ok(updatedAction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
}
    @DeleteMapping(path = "/api/admin/delete/{type}/{id}")
    public ResponseEntity<String> deleteAdminAction(@PathVariable String type, @PathVariable Long id) {
        AdminActions adminAction = adminActionsRepository.findById(id).orElse(null);
        if (adminAction != null) {
            adminActionsRepository.delete(adminAction);
            return ResponseEntity.ok("Admin action deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin action not found.");
        }
}
    @DeleteMapping("/api/forum/delete/{postId}")
    public ResponseEntity<String> deleteForumPost(@PathVariable Long postId) {
        try {
            postRepository.deleteByPostId(postId);
            return ResponseEntity.ok("Forum post deleted successfully");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
}
    @PutMapping(path = "/api/forum/edit/{postId}")
    public ResponseEntity<ForumPost> updateForumPost(@PathVariable Long postId, @RequestBody ForumPost updatedPost) {
        ForumPost existingPost = postRepository.findById(postId)
        .orElseThrow(() -> new ResourceNotFoundException("ForumPost not found with ID: " + postId));
        ForumPost savedPost = postRepository.save(existingPost);
        return ResponseEntity.ok(savedPost);
}
    @PosttMapping(path = "/api/auth/login/{adminId}",consumes = "application/json",produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> setRole(@PathVariable("adminId") Long adminId,@RequestParam ERole role) {
        Optional<User> userOptional = userRepository.findById(adminId);
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