package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Gate_Fortified extends Event {

    public Gate_Fortified() {
        super("{GATE FORTIFIED}\n+1 to attacks on Battering Rams.");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }
    
}
