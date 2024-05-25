@Entity
@Table(name = "System Log")
public class SystemLog{
    @Column(name = "LogID")
    private Int LogID;

    @Column(name = "RelatedActionID")
    private Int RelatedActionID;

    @Column(name = "TimeStamp")
    private Timestamp TimeStamp;

    @Column(name = "Description")
    private String Description;
}
public SystemLog(Int LogID,Int RelatedActionID,Timestamp TimeStamp,String Description){
    this.LogID = LogID;
    this.RelatedActionID = RelatedActionID;
    this.TimeStamp = TimeStamp;
    this.Description = Description;
}
public Int getLogID(){
    return LogID;
}
public void setLogID(Int LogID){
    this.LogID = LogID;
}
public Int getRelatedActionID(){
    return RelatedActionID;
}
public void setRelatedActionID(Int RelatedActionID){
    this.RelatedActionID = RelatedActionID;
}
public Timestamp getTimeStamp(){
    return TimeStamp;
}
public void setTimeStamp(Timestamp TimeStamp){
    this.TimeStamp = TimeStamp;
}
public String getDescription(){
    return Description;
}
public void setDescription(String Description){
    this.Description = Description;
}