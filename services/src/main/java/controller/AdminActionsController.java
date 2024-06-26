package controller;

import data.repository.AdminActionsRepository;
import data.domain.AdminActions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/adminactions")
public class AdminActionsController {

    @Autowired
    private AdminActionsRepository adminActionsRepository;

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
    
    @GetMapping(path = "/api/auth/login/{adminId}",produces = "application/json")
    public ResponseEntity<String> showAdminContent(Principal principal) {
    String message = "Welcome, " + principal.getName() + "! <BR> Only an admin can view this content.";
    return new ResponseEntity<>(message, HttpStatus.OK);
    }
}