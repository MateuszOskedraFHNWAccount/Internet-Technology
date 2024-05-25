@Entity
@Table(name = "Admin Actions")
public class AdminActions{
    @Column(name = "ActionID")
    private Int ActionID;

    @Column(name = "AdminID")
    private Int AdminID;

    @Column(name = "ActionType")
    private Actiontype ActionType;

    @Column(name = "TargetID")
    private Int TargetID;

    @Column(name = "TimeStamp")
    private Timestamp TimeStamp;
}
public AdminActions(Int ActionID,Int AdminID,Actiontype ActionType,
    Int TargetID,Timestamp TimeStamp) {
    this.ActionID = ActionID;
    this.AdminID = AdminID;
    this.ActionType = ActionType;
    this.TargetID = TargetID;
    this.TimeStamp = TimeStamp;
    }
public Int getActionID(){
    return ActionID;
}
public void setActionID(Int ActionID){
    this.ActionID = ActionID
}
public Int getAdminID(){
    return AdminID;
}
public void setAdminID(Int AdminID){
    this.AdminID = AdminID;
}
public Actiontype getActionType(){
    return ActionType;
}
public void setActionType(Actiontype ActionType){
    this.ActionType = ActionType;
}
public enum Actiontype {
    MODIFY, DELETE, ASSIGN
}
public Int getTargetID(){
    return TargetID;
}
public void setTargetID(Int TargetID){
    this.TargetID = TargetID;
}
public Timestamp getTimeStamp(){
    return TimeStamp;
}
public void setTimeStamp(Timestamp TimeStamp){
    this.TimeStamp = TimeStamp;
}