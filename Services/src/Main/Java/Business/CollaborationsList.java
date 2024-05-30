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

    public AccountManagement updateAccountManagement(Int ManagementID, AccountManagement updatedAccount) throws ResourceNotFoundException {
        AccountManagement existingAccount = accountManagementRepository.findById(ManagementID);
        if(existingAccount != null){
            if(updatedAccount.getActionType() != null)
                existingAccount.setActionType(updatedAccount.getActionType());
            if(updatedAccount.getTimeStamp() != null)
                existingAccount.setTimeStamp(updatedAccount.getTimeStamp());
                return accountManagementRepository.save(existingAccount)
            }
            throw new ResourceNotFoundException("Account not found with ID: " + ManagementID));
    }
}
    public void deleteAccountManagement(Int ManagementID) throws Exception{
        if(accountManagementRepository.existsById(ManagementID)){
            accountManagementRepository.deleteById(ManagementID);
        } else 
            throw new Exception("Account management record " + ManagementID + " was deleted successfully.");
}
    public AccountManagement createAccountManagement(AccountManagement accountManagement) throws Exception {
        if(accountManagement.getActionType() != null)
            if(accountManagementRepository.findByActionType(accountManagement.getActionType()) == null)
                return accountManagementRepository.save(accountManagement);
        throw new Exception("Account management record " + accountManagement.getActionType() + " already available");
    } 
    throw new Exception("Invalid action type");
} 
    public User setRole(Long superadminId,ERole role) {
        Optional<User> userOptional = userRepository.findById(superadminId);
        Optional<Role> roleOptional = roleRepository.findByName(role);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role assignedRole = roleOptional.get();

            user.getRoles().add(assignedRole);
            userRepository.save(user);

            return userRepository.ok(user);
        } else {
            return user.notFound().build();
    }
}
    public enum ERole {
    ROLE_STUDENT,
    ROLE_SUPERADMIN,
    ROLE_ADMIN
}



    public AdminActions updateAdminAction(Actiontype ActionType,Int ActionID,AdminActions adminAction) {
        AdminActions existingAction = adminActionsRepository.findById(ActionID).orElse(null);
        if (existingAction != null) {
            existingAction.setType(ActionType);
            AdminActions updatedAction = adminActionsRepository.save(existingAction);
            return adminActionsRepository.ok(updatedAction);
        } else {
            return updatedAction.status(HttpStatus.NOT_FOUND).body(null);
    }
}
    public AdminActions<String> deleteAdminAction(Actiontype ActionType,Int ActionID) {
        AdminActions adminAction = adminActionsRepository.findById(ActionID).orElse(null);
        if (adminAction != null) {
            adminActionsRepository.delete(adminAction);
            return adminAction.ok("Admin action deleted successfully!");
        } else {
            return adminAction.status(HttpStatus.NOT_FOUND).body("Admin action not found.");
    }
}
    public ForumPost deleteForumPost(Int PostID) {
        try {
            forumPostRepository.deleteByPostId(PostID);
            return PostID.ok("Forum post deleted successfully");
        } catch (EmptyResultDataAccessException e) {
            return PostID.notFound().build();
        }
}
    public ForumPost updateForumPost(Int PostID,ForumPost updatedPost) {
        ForumPost existingPost = forumPostRepository.findById(PostID)
        .orElseThrow(() -> new ResourceNotFoundException("ForumPost not found with ID: " + PostID));
        ForumPost savedPost = forumPostRepository.save(existingPost);
        return forumPostRepository.ok(savedPost);
}
    public User setRole(Long adminId,ERole role) {
        Optional<User> userOptional = userRepository.findById(adminId);
        Optional<Role> roleOptional = roleRepository.findByName(role);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role assignedRole = roleOptional.get();

            user.getRoles().add(assignedRole);
            userRepository.save(user);

            return userRepository.ok(user);
        } else {
            return user.notFound().build();
    }
}
    public enum ERole {
    ROLE_STUDENT,
    ROLE_SUPERADMIN,
    ROLE_ADMIN
    }
}
    public BuddySystem createBuddySystem(BuddySystem buddySystem) {
        BuddySystem savedBuddySystem = buddySystemRepository.save(buddySystem);
        return saveBuddySystem.status(HttpStatus.CREATED).body(savedBuddySystem);
    }
}
    public List<BuddySystem> getAllBuddySystems(String Languages) {
        List<BuddySystem> buddySystems = buddySystemRepository.findByLanguage(Languages);
        return buddySystemRepository.ok(buddySystems);
    }
}
    public ForumPost createForumPost(ForumPost forumPost) {
        ForumPost savedPost = forumPostRepository.save(forumPost);
        return savedPost.status(HttpStatus.CREATED).body(savedPost);
    }
}
    public ForumResponse createForumResponse(Int ResponseID,ForumResponse forumResponse) {
        forumResponse.setResponseID(ResponseID);
        ForumResponse savedResponse = forumResponseRepository.save(forumResponse);
        return savedResponse.status(HttpStatus.CREATED).body(savedResponse);
    }
}
    public IndependentProject createIndependentProject(IndependentProject independentProject) {
        IndependentProject savedProject = independentProjectRepository.save(independentProject);
        return savedProject.status(HttpStatus.CREATED).body(savedProject);
}
    public ResponseEntity createJobAdvertisement(JobAdvertisement jobAdvertisement) {
    try {
        entityManager.persist(jobAdvertisement);
        return jobAdvertisement.ok("Job advertisement created successfully.");
    } catch (Exception e) {
        return jobAdvertisement.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
    public MentoringForProjects createMentoringForProjects(MentoringForProjects mentoringForProjects) {
        MentoringForProjects savedMentoring = mentoringRepository.save(mentoringForProjects);
        return savedMentoring.status(HttpStatus.CREATED).body(savedMentoring);
}
    public List<MentoringForProjects> getAllMentoringForProjects() {
        List<MentoringForProjects> mentoringList = mentoringRepository.findAll();
        return mentoringList.ok(mentoringList);
}
    public RoomAssignment createRoomAssignment(RoomAssignment roomAssignment) {
        RoomAssignment savedAssignment = roomAssignmentRepository.save(roomAssignment);
        return savedAssignment.status(HttpStatus.CREATED).body(savedAssignment);
}
    public List<SystemLog> getAllSystemLogs() {
        List<SystemLog> systemLogs = systemLogRepository.findAll();
        return systemLogs.ok(systemLogs);
}
    public TutoringSession createTutoringSession(TutoringSession tutoringSession) {
        TutoringSession savedSession = tutoringSessionRepository.save(tutoringSession);
        return savedSession.status(HttpStatus.CREATED).body(savedSession);
}
    public List<TutoringSession> getAllTutoringSession(String Subject,boolean Recurring) {
        List<TutoringSession> tutoringSessions = tutoringSessionRepository.findBySubjectAndRecurring(subject, recurring);
        return tutoringSessions.ok(tutoringSessions);
}
    public User createUser(User user) {
    try {
        entityManager.persist(user);
        return user.ok("User created successfully.");
    } catch (Exception e) {
        return user.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    public User updateUser(User updatedUser) {
    try {
        User existingUser = userRepository.findById(updatedUser.getId(UserID))
        .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + updatedUser.getId(UserID)));
        existingUser.setSomeProperty(updatedUser.getSomeProperty());
        userRepository.save(existingUser);
        return existingUser.ok("User updated successfully.");
    } catch (ResourceNotFoundException e) {
        return existingUser.notFound().build();
    } catch (Exception e) {
        return existingUser.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    public User deleteUser(Int UserID) {
    try {
        Optional<User> optionalUser = userRepository.findById(UserID);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
            return user.ok("User deleted successfully.");
        } else {
            return user.notFound().build();
        }
    } catch (Exception e) {
        return user.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
    public User setRole(Long studentId,ERole role) {
        Optional<User> userOptional = userRepository.findById(studentId);
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