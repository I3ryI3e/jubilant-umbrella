
package Card_Events;

import Model.Event;
import Model.Game;
import Model.Siege_Game;

public class Flaming_Arrows extends Event {

    public Flaming_Arrows() {
        super("{FLAMING ARROWS}\n+1 to attacks on Siege Tower.");
    }

    @Override
    public void runEvent(Game game) {
    }

    @Override
    public int getSiegeMod() {
        return 1;
    }
    
}
