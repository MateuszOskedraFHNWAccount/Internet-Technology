@Entity
@Table(name = "Account Management")
public class AccountManagement{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "ManagementID")
    private Int ManagementID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "AdminID")
    private Int AdminID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "TargetUserID")
    private Int TargetUserID;

    @Column(name = "ActionType")
    private Actiontype ActionType;

    @Column(name = "TimeStamp")
    private Timestamp TimeStamp;

}
public AccountManagement(Int ManagementID,Int AdminID,Int TargetUserID,
    Actiontype ActionType,Timestamp TimeStamp){
    this.ManagementID = ManagementID;
    this.AdminID = AdminID;
    this.TargetUserID = TargetUserID;
    this.ActionType = ActionType;
    this.TimeStamp = TimeStamp;
}
public Int getManagementID(){
    return ManagementID;
}
public void setManagementID(Int ManagementID){
    this.ManagementID = ManagementID;
}
public Int getAdminID(){
    return AdminID;
}
public void setAdminID(Int AdminID){
    this.AdminID = AdminID;
}
public Int getTargetUserID(){
    return TargetUserID;
}
public void setTargetUserID(Int TargetUserID){
    this.TargetUserID = TargetUserID;
}
public Actiontype getActionType(){
    return ActionType;
}
public void setActionType(Actiontype ActionType){
    this.ActionType = ActionType;
}
    public enum Actiontype {
        CREATE, MODIFY, DELETE
}
public Timestamp getTimeStamp(){
    return TimeStamp;
}
public void setTimeStamp(Timestamp TimeStamp){
    this.TimeStamp = TimeStamp;
}