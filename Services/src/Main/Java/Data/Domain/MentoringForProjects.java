@Entity
@Table(name = "Mentoring for Projects")
public class MentoringForProjects{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "ProjectID")
    private Int ProjectID; 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "MentorID")
    private Int MentorID;

    @Column(name = "Subject")
    private String Subject;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Reccuring")
    private Boolean Recurring;

    @Column(name = "ProjectName")
    private String ProjectName;

    @Column(name = "StartTime")
    private Timestamp StartTime;

    @Column(name = "EndTime")
    private Timestamp EndTime;

}
public MentoringForProjects(Int ProjectID,Int MentorID,
    String Subject,String Description,Boolen Reccuring,
    String ProjectName,Timestamp StartTime,Timestamp EndTime){
    this.ProjectID = ProjectID;
    this.MentorID = MentorID;
    this.Subject = Subject;
    this.Description = Description;
    this.Reccuring = Reccuring;
    this.ProjectName = ProjectName;
    this.StartTime = StartTime;
    this.EndTime = EndTime;
}
public Int getProjectID(){
    return ProjectID;
}
public void setProjectID(Int ProjectID){
    this.ProjectID = ProjectID;
}
public Int getMentorID(){
    return MentorID;
}
public void setMentorID(Int MentorID){
    this.MentorID = MentorID;
}
public String getSubject(){
    return Subject;
}
public void setSubject(String Subject){
    this.Subject = Subject;
}
public String getDescription(){
    return Description;
}
public void setDescription(String Description){
    this.Description = Description;
}
public Boolean getReccuring(){
    return Reccuring;
}
public void setRecurring(Boolean Reccuring){
    this.Reccuring = Reccuring;
}
public String getProjectName(){
    return ProjectName;
}
public void setProjectName(String ProjectName){
    this.ProjectName = ProjectName;
}
public Timestamp getStartTime(){
    return StartTime;
}
public void setStartTime(Timestamp StartTime){
    this.StartTime = StartTime;
}
public Timestamp getEndTime(){
    return EndTime;
}
public void setEndTime(Timestamp EndTime){
    this.EndTime = EndTime;
}