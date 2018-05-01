package Card_Events;

import Model.Event;
import Model.Game;
import Model.Siege_Game;

public class Iron_Shields extends Event {

    public Iron_Shields() {
        super("{IRON SHIELDS}\n-1 to attacks on Siege Tower.");
    }

    @Override
    public void runEvent(Game game) {
    }

    @Override
    public int getSiegeMod() {
        return -1;
    }
    
    
}
