package Model;

public abstract class Event {
    private final String text;
    
    public Event(String t){
        text=t;
    }
    public String getText(){
        return text;
    }
    public int getLadderMod(){
        return 0;
    }
    public int getRamMod(){
        return 0;
    }
    public int getSiegeMod(){
        return 0;
    }
    public int getMoraleMod(){
        return 0;
    }
    public int getSupplyMod(){
        return 0;
    }
    public int getSabotageMod(){
        return 0;
    }
    public int getRaidMod(){
        return 0;
    }
    public int getCoupureMod(){
        return 0;
    }
    public int getCircleAttackMod(){
        return 0;
    }
    public int getCloseCombatMod(){
        return 0;
    }
    public int getBoilingWaterMod(){
        return 0;
    }
    abstract public void runEvent(Siege_Game game);

    @Override
    public String toString() {
        return text + "\n";
    }
    
}

