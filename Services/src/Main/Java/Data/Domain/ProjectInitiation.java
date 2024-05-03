public class ProjectInitiation{
    private String Title;
    private Boolean FrequencyOfEvent = false;
    private String Description;
    private String Timeline;
}
public ProjectInitiation(String Title,Boolean FrequencyOfEvent,String Description,String Timeline){
    this.Title = Title;
    this.FrequencyOfEvent = FrequencyOfEvent;
    this.Description = Description;
    this.Timeline = Timeline;
}
public String getTitle(){
    return Title;
}
public void setTitle(String Title){
    this.Title = Title;
}
public Boolean FrequencyOfEvent(int input){
    if(int input = 1){
    return FrequencyOfEvent = true;
} else if(int input = 0){
    return FrequencyOfEvent = false;
}
}
public Boolean getFrequencyOfEvent(){
    return FrequencyOfEvent;
}
public String getDescription(){
    return Description;
}
public void setDescription(String Description){
    this.Description = Description;
}
public String getTimeline(){
    return Timeline;
}
public void setTimeline(String Timeline){
    this.Timeline = Timeline;
}