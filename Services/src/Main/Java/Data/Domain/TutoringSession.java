@Entity
@Table(name = "Tutoring Session")
public class TutoringSession{
    @Column(name = "SessionID")
    private Int SessionId;

    @Column(name = "Subject")
    private String Subject;

    @Column(name = "Description")
    private String Description;

    @Column(name = "TutorID")
    private Int TutorId;

    @Column(name = "StudentID")
    private Int StudentId;

    @Column(name = "Reccuring")
    private Boolean Reccuring;

    @Column(name = "StartTime")
    private Timestamp StartTime;

    @Column(name = "EndTime")
    private Timestamp EndTime;

    @Column(name = "Status")
    private SessionStatus Status;

}
public TutoringSession(Int SessionID,String Subject,String Description,
    Int TutorID,Int StudentID,Boolean Reccuring,Timestamp StartTime,
    Timestamp EndTime,SessionStatus Status){
    this.SessionID = SessionID;
    this.Subject = Subject;
    this.Description = Description;
    this.TutorID = TutorID;
    this.StudentID = StudentID;
    this.Reccuring = Reccuring;
    this.StartTime = StartTime;
    this.EndTime = EndTime;
    this.Status = Status;
}
public Int getSessionID(){
        return SessionID;
}
public void setSessionID(Int SessionID){
    this.SessionID = SessionID;
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
public Int getTutorID(){
    return TutorID;
}
public void setTutorID(Int TutorID){
    this.TutorID = TutorID;
}
public Int getStudentID(){
    return StudentID;
}
public void setStudentID(Int StudentID){
    this.StudentID = StudentID;
}
public Boolean getReccuring(){
    return Reccuring;
}
public void setRecurring(Boolean Reccuring){
    this.Reccuring = Reccuring;
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
public SessionStatus getStatus(){
    return Status;
}
public void setStatus(SessionStatus Status){
    this.Status = Status;
}
public enum SessionStatus {
    ACTIVE, COMPLETED, CANCELLED
}