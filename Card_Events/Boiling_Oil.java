package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Boiling_Oil extends Event {

    public Boiling_Oil() {
        super("+2 to attack on enemies on circle spaces.");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getCircleAttackMod() {
        return 2;
    }
    
    
    
}
