package Card_Events;

import Model.Game;

public class Repaired_Trebuchet extends Event{

    public Repaired_Trebuchet() {
        super("{REPAIRED TREBUCHET}\nAdd 1 Trebuchet (max 3).\n+1 to Coupure action.");
    }
    

    @Override
    public void runEvent(Game game) {
        game.addTrebuchetEvent();
    }

    @Override
    public int getCoupureMod() {
        return 1;
    }
    
    
}
