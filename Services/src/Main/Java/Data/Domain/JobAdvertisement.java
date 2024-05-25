@Entity
@Table(name = "Job Advertisement")
public class JobAdvertisement {
    @Column(name = "JobAdID")
    private Int JobAdID;

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

    
