package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Volley_of_Arrows extends Event{

    public Volley_of_Arrows() {
        super("{VALLEY OF ARROWS}\n+1 to all attacks");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getRamMod() {
        return 1;
    }

    @Override
    public int getSiegeMod() {
        return 1;
    }

    @Override
    public int getLadderMod() {
        return 1;
    }

    @Override
    public int getBoilingWaterMod() {
        return 1;
    }

    @Override
    public int getCloseCombatMod() {
        return 1;
    }
    
    
    
    
}
