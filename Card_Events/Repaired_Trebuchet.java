package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Repaired_Trebuchet extends Event{

    public Repaired_Trebuchet() {
        super("{REPAIRED TREBUCHET}\nAdd 1 Trebuchet (max 3).\n+1 to Coupure action.");
    }
    

    @Override
    public void runEvent(Siege_Game game) {
        //TODO
    }

    @Override
    public int getCoupureMod() {
        return 1;
    }
    
    
}
