
package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Enemy_Fatigue extends Event {

    public Enemy_Fatigue() {
        super("{ENEMY FATIGUE}\n+1 to Coupure, Raid and Sabotage actions.");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getCoupureMod() {
        return 1;
    }

    @Override
    public int getRaidMod() {
        return 1;
    }

    @Override
    public int getSabotageMod() {
        return 1;
    }
    
    
    
    
}
