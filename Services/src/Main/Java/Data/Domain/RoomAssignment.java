public class RoomAssignment{
    private Boolean FrequencyOfEvent = false;
    private String Timeline;
}
public RoomAssignment(Boolean FrequencyOfEvent,String Timeline){
    this.FrequencyOfEvent = FrequencyOfEvent;
    this.Timeline = Timeline;
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
public String getTimeline(){
    return Timeline;
}
public void setTimeline(String Timeline){
    this.Timeline = Timeline;
}