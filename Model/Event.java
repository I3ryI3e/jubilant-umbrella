package Model;

public abstract class Event {
    private String text;
    
    abstract String getText();
    abstract public void runEvent(Siege_Game game);
}
