
package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Flaming_Arrows extends Event {

    public Flaming_Arrows() {
        super("+1 to attacks on Siege Tower.");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getSiegeMod() {
        return 1;
    }
    
}
