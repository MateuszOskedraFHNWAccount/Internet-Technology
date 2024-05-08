public class JobAdvertisements{
    private String Role;
    private String Requirements;
    private String ApplicationProcess;
    private Date Deadline;
}
public JobAdvertisements(String Role,String Requirements,String ApplicationProcess,Date Deadline){
    this.Role = Role;
    this.Requirements = Requirements;
    this.ApplicationProcess = ApplicationProcess;
    this.Deadline = Deadline;
}
public String getRole(){
    return Role;
}
public void setRole(String Role){
    this.Role = Role;
}
public String getRequirements(){
    return Requirements;
}
public void setRequirements(String Requirements){
    this.Requirements = Requirements;
}
public String getApplicationProcess(){
    return ApplicationProcess;
}
public void setApplicationProcess(String ApplicationProcess){
    this.ApplicationProcess = ApplicationProcess;
}
public Date getDeadline(){
    return Deadline;
}
public void setDeadline(Date Deadline){
    this.Deadline = Deadline;
}