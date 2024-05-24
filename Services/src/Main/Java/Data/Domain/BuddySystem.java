@Entity
@Table(name = "Buddy System")
public class BuddySystem {
    @Column(name = "BuddyPairID")
    private Int BuddyPairID;

    @Column(name = "LocalStudentID")
    private Int LocalStudentID;

    @Column(name = "InternationalStudentID")
    private Int InternationalStudentID;

    @Column(name = "Languages")
    private String Languages;

    @Column(name = "Status")
    private BuddyStatus status;

    public enum BuddyStatus {
        ACTIVE, COMPLETED

}
public BuddySystem(Int BuddyPairID,Int LocalStudentID,Int InternationalStudentID,
    String Languages,BuddyStatus Status){
    this.BuddyPairID = BuddyPairID;
    this.LocalStudentID = LocalStudentID;
    this.InternationalStudentID = InternationalStudentID;
    this.Languages = Languages;
    this.Status = Status;
}
public Int getBuddyPairID(){
    return BuddyPairID;
}
public void setBuddyPairID(Int BuddyPairID){
    this.BuddyPairID = BuddyPairID;
}
public Int getLocalStudentID(){
    return LocalStudentID;
}
public void setLocalStudentID(Int LocalStudentID){
    this.LocalStudentID = LocalStudentID;
}
public Int getInternationalStudentID(){
    return InternationalStudentID;
}
public void setInternationalStudentID(Int InternationalStudentID){
    this.InternationalStudentID = InternationalStudentID;
}
public String getLanguages(){
    return Languages;
}
public void setLanguages(String Languages){
    this.Languages = Languages;
}
public BuddyStatus getStatus(){
    return Status;
}
public void setStatus(BuddyStatus Status){
    this.Status = Status;
}