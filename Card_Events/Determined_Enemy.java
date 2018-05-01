package Card_Events;

import Model.Event;
import Model.Game;
import Model.Siege_Game;

public class Determined_Enemy extends Event {

    public Determined_Enemy() {
        super("{DETERMINED ENEMY}\n-1 to attacks on Battering Ram");
    }

    @Override
    public void runEvent(Game game) {
    }

    @Override
    public int getRamMod() {
        return -1;
    }
}
