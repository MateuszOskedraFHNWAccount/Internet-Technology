import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Services.src.Main.Java.Data.Domain.AccountManagement;
import Services.src.Main.Java.Data.Domain.AdminActions;
import Services.src.Main.Java.Data.Domain.BuddySystem;
import Services.src.Main.Java.Data.Domain.ForumPost;
import Services.src.Main.Java.Data.Domain.ForumResponse;
import Services.src.Main.Java.Data.Domain.IndependentProject;
import Services.src.Main.Java.Data.Domain.JobAdvertisement;
import Services.src.Main.Java.Data.Domain.MentoringForProjects;
import Services.src.Main.Java.Data.Domain.RoomAssignment;
import Services.src.Main.Java.Data.Domain.SystemLog;
import Services.src.Main.Java.Data.Domain.TutoringSession;
import Services.src.Main.Java.Data.Domain.User;

import Services.src.Main.Java.Data.Repository.AccountManagementRepository;
import Services.src.Main.Java.Data.Repository.AdminActionsRepository;
import Services.src.Main.Java.Data.Repository.BuddySystemRepository;
import Services.src.Main.Java.Data.Repository.ForumPostRepository;
import Services.src.Main.Java.Data.Repository.ForumResponseRepository;
import Services.src.Main.Java.Data.Repository.IndependentProjectRepository;
import Services.src.Main.Java.Data.Repository.JobAdvertisementRepository;
import Services.src.Main.Java.Data.Repository.MentoringForProjectsRepository;
import Services.src.Main.Java.Data.Repository.RoomAssignmentRepository;
import Services.src.Main.Java.Data.Repository.SystemLogRepository;
import Services.src.Main.Java.Data.Repository.TutoringSessionRepository;
import Services.src.Main.Java.Data.Repository.UserRepository;

@Service
public class CollaborationsList {

    @Autowired
    private AccountManagementRepository accountManagementRepository;

    @Autowired
    private AdminActionsRepository adminActionsRepository;

    @Autowired
    private BuddySystemRepository buddySystemRepository;

    @Autowired
    private ForumPostRepository forumPostRepository;

    @Autowired
    private ForumResponseRepository forumResponseRepository;

    @Autowired
    private IndependentProjectRepository independentProjectRepository;

    @Autowired 
    private JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    private MentoringForProjectsRepository mentoringForProjectsRepository;

    @Autowired
    private RoomAssignmentRepository roomAssignmentRepository;

    @Autowired
    private SystemLogRepository systemLogRepository;

    @Autowired
    private TutoringSessionRepository tutoringSessionRepository;

    @Autowired
    private UserRepository userRepository;

    public <?> updateAccountManagement(Long adminId,AccountManagement updatedAccount) {
    try {
        AccountManagement existingAccount = accountManagementRepository.findById(adminId)
        .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + adminId));
        existingAccount.setSomeProperty(updatedAccount.getSomeProperty());
        AccountManagement savedAccount = accountManagementRepository.save(existingAccount);
        return accountManagementRepository.ok(savedAccount);
    } catch (ResourceNotFoundException e) {
        return savedAccount.notFound().build();
    } catch (Exception e) {
        return savedAccount.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    public <?> deleteAccountManagement(Long adminId) {
    try {
        Optional<AccountManagement> optionalAccount = accountManagementRepository.findById(adminId);
        if (optionalAccount.isPresent()) {
            AccountManagement accountManagement = optionalAccount.get();
            accountManagementRepository.delete(accountManagement);
            return accountManagement.ok("Account management record deleted successfully.");
        } else {
            return accountManagement.notFound().build();
        }
    } catch (Exception e) {
        return accountManagement.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting account management record.");
    }
}
    public <?> createAccountManagement(AccountManagement accountManagement) {
    try {
        AccountManagement savedAccount = accountManagementRepository.save(accountManagement);
        return savedAccount.ok("Account management record created successfully.");
    } catch (Exception e) {
        return savedAccount.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    public <User> setRole(Long superadminId,ERole role) {
        Optional<User> userOptional = userRepository.findById(superadminId);
        Optional<Role> roleOptional = roleRepository.findByName(role);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role assignedRole = roleOptional.get();

            user.getRoles().add(assignedRole);
            userRepository.save(user);

            return user.ok(user);
        } else {
            return user.notFound().build();
    }
}
    public enum ERole {
    ROLE_STUDENT,
    ROLE_SUPERADMIN,
    ROLE_ADMIN
}
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
    @PostMapping(path = "/api/buddy/volunteer",consumes = "application/json",produces = "application/json")
    public ResponseEntity<BuddySystem> createBuddySystem(@RequestBody BuddySystem buddySystem) {
        BuddySystem savedBuddySystem = buddySystemRepository.save(buddySystem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuddySystem);
}
    @GetMapping(path = "/api/buddy/match?language={language}",produces = "application/json")
    public ResponseEntity<List<BuddySystem>> getAllBuddySystems(@RequestParam(name = "language") String language) {
        List<BuddySystem> buddySystems = buddySystemRepository.findByLanguage(language);
        return ResponseEntity.ok(buddySystems);
    }
    @PostMapping(value = "/api/admin/buddy/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> assignBuddyToInternationalStudent(@RequestBody BuddyAssignmentRequest request) {
        boolean assignmentSuccessful = buddyAssignmentService.assignBuddy(request.getInternationalStudentId(), request.getBuddyId());
        if (assignmentSuccessful) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Buddy assigned successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to assign buddy.");
    }
}
    @PostMapping(path = "/api/forum/posts",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ForumPost> createForumPost(@RequestBody ForumPost forumPost) {
        ForumPost savedPost = forumPostRepository.save(forumPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }
}
    @PostMapping(path = "/api/forum/posts/{postId}/responses", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ForumResponse> createForumResponse(@PathVariable Long postId, @RequestBody ForumResponse forumResponse) {
        forumResponse.setPostId(postId);
        ForumResponse savedResponse = forumResponseRepository.save(forumResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResponse);
    }
}
    @PostMapping(path = "/api/projects/independent",consumes = "application/json",produces = "application/json")
    public ResponseEntity<IndependentProject> createIndependentProject(@RequestBody IndependentProject independentProject) {
        IndependentProject savedProject = independentProjectRepository.save(independentProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
}
    @PostMapping(path = "/api/admin/jobs",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
    try {
        entityManager.persist(jobAdvertisement);
        return ResponseEntity.ok("Job advertisement created successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    @PostMapping(path = "/api/admin/advertisements".consumes = "application/json",produces = "application/json")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAdvertisement = advertisementService.saveAdvertisement(advertisement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdvertisement);
}
    @PostMapping(path = "/api/projects/mentorship/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity<MentoringForProjects> createMentoringForProjects(@RequestBody MentoringForProjects mentoringForProjects) {
        MentoringForProjects savedMentoring = mentoringRepository.save(mentoringForProjects);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMentoring);
}
    @GetMapping(path = "/api/projects/mentorship/search?subject={subject}&recurring={true|false}", produces = "application/json")
    public ResponseEntity<List<MentoringForProjects>> getAllMentoringForProjects() {
        List<MentoringForProjects> mentoringList = mentoringRepository.findAll();
        return ResponseEntity.ok(mentoringList);
}
    @PostMapping(path = "/api/rooms/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<RoomAssignment> createRoomAssignment(@RequestBody RoomAssignment roomAssignment) {
        RoomAssignment savedAssignment = roomAssignmentRepository.save(roomAssignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAssignment);
}
    @GetMapping(path = "/api/admin/logs",produces = "application/json")
    public ResponseEntity<List<SystemLog>> getAllSystemLogs() {
        List<SystemLog> systemLogs = systemLogRepository.findAll();
        return ResponseEntity.ok(systemLogs);
}
    @PostMapping(path = "/api/tutoring/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity<TutoringSession> createTutoringSession(@RequestBody TutoringSession tutoringSession) {
        TutoringSession savedSession = tutoringSessionRepository.save(tutoringSession);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSession);
}
    @GetMapping(path = "/api/tutoring/search?subject={subject}&recurring={true|false}",produces = "application/json")
    public ResponseEntity<List<TutoringSession>> getAllTutoringSessions(@RequestParam(name = "subject") String subject,
        @RequestParam(name = "recurring", defaultValue = "false") boolean recurring) {
        List<TutoringSession> tutoringSessions = tutoringSessionRepository.findBySubjectAndRecurring(subject, recurring);
        return ResponseEntity.ok(tutoringSessions); 
}
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