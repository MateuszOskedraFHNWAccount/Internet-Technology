@Entity
@Table(name = "Job Advertisement")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "JobAdID")
    private Int JobAdID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "AdminID")
    private Int AdminID;

    @Column(name = "Title")
    private String Title;

    @Column(name = "Description")
    private String Description;

    @Column(name = "ApplicationDeadline")
    private Timestamp ApplicationDeadline;

    @Column(name = "ContactInfo")
    private String ContactInfo;
}
public JobAdvertisement(Int JobAdID,Int AdminID,String Title,
    String Description,Timestamp ApplicationDeadline,String ContactInfo){
    this.JobAdID = JobAdID;
    this.AdminID = AdminID;
    this.Title = Title;
    this.Description = Description;
    this.ApplicationDeadline = ApplicationDeadline;
    this.ContactInfo = ContactInfo;
}
public Int getJobAdID(){
    return JobAdID;
}
public void setJobAdID(Int JobAdID){
    this.JobAdID = JobAdID;
}
public Int getAdminID(){
    return AdminID;
}
public void setAdminID(Int AdminID){
    this.AdminID = AdminID;
}
public String getTitle(){
    return Title;
}
public void setTitle(String Title){
    this.Title = Title;
}
public String getDescription(){
    return Descripton;
}
public void setDescripton(String Description){
    this.Description = Description;
}
public Timestamp getApplicationDeadline(){
    return ApplicationDeadline;
}
public void setApplicationDeadline(Timestamp ApplicationDeadline){
    this.ApplicationDeadline = ApplicationDeadline;
}
public String getContactInfo(){
    return ContactInfo;
}
public void setContactInfo(String ContactInfo){
    this.ContactInfo = ContactInfo;
}