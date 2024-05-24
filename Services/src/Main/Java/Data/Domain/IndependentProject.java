@Entity
@Table(name = "Independent Project")
public class IndependentProject{
    private Integer projectId; // Primary Key
    private Integer leaderId; // Foreign Key to User.UserID
    private String projectName;
    private String description;
    private Boolean recurring;
    private Timestamp startTime;
    private Timestamp endTime;

    // getters and setters
}
