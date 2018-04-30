package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Faith extends Event{

    public Faith() {
        super("{FAITH}\n+1 to attacks on Battering Ram, Ladders and Morale action.");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getRamMod() {
        return 1;
    }

    @Override
    public int getLadderMod() {
        return 1;
    }

    @Override
    public int getMoraleMod() {
        return 1;
    }
    
    
    
}
