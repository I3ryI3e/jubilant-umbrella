package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Determined_Enemy extends Event {

    public Determined_Enemy() {
        super("-1 to attacks on Battering Ram");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getRamMod() {
        return -1;
    }
}