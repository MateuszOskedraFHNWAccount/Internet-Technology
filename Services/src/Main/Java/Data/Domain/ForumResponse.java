@Entity
@Table(name = "Forum Response")
public class ForumResponse{
    @Column(name = "ResponseID")
    private Int ResponseID;

    @Column(name = "PostID")
    private Int PostID;

    @Column(name = "AuthorID")
    private Int AuthorID;

    @Column(name = "Content")
    private String Content;

    @Column(name = "ResponseTime")
    private Timestamp ResponseTime;
}
public ForumResponse(Int ResponseID,Int PostID,Int AuthorID,String Content,
    Timestamp ResponseTime){
    this.ResponseID = ResponseID;
    this.PostID = PostID;
    this.AuthorID = AuthorID;
    this.Content = Content;
    this.ResponseTime = ResponseTime;
}
public Int getResponseID(){
    return ResponseID;
}
public void setResponseID(Int ResponseID){
    this.ResponseID = ResponseID;
}
public Int getPostID(){
    return PostID;
}
public void setPostID(Int PostID){
    this.PostID = PostID;
}
public Int getAuthorID(){
    return AuthorID;
}
public void setAuthorID(Int AuthorID){
    this.AuthorID = AuthorID;
}
public String getContent(){
    return Content;
}
public void setContent(String Content){
    this.Content = Content;
}
public Timestamp getResponseTime(){
    return ResponseTime;
}
public void setResponseTime(Timestamp ResponseTime){
    this.ResponseTime = ResponseTime;
}