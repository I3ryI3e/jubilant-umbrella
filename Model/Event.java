package Model;

public abstract class Event {
    private final String text;
    
    public Event(String t){
        text=t;
    }
    public String getText(){
        return text;
    }
    abstract public void runEvent(Siege_Game game);
}

