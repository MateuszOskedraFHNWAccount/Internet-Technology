@Entity
@Table(name = "Forum Post")
public class ForumPost{
    @Column(name = "PostID")
    private Int PostID;

    @Column(name = "AuthorID")
    private Int AuthorID;

    @Column(name = "Content")
    private String Content;

    @Column(name = "Topic")
    private String Topic;

    @Column(name = "CreationTime")
    private Timestamp CreationTime;
}
public ForumPost(Int PostID,Int AuthorID,String Content,String Topic,
    Timestamp CreationTime){
    this.PostID = PostID;
    this.AuthorID = AuthorID;
    this.Content = Content;
    this.Topic = Topic;
    this.CreationTime = CreationTime;
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
public String getTopic(){
    return Topic;
}
public void setTopic(String Topic){
    this.Topic = Topic;
}
public Timestamp getCreationTime(){
    return CreationTime;
}
public void setCreationTime(Timestamp CreationTime){
    this.CreationTime = CreationTime;
}