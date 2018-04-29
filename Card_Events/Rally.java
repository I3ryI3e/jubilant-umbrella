package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Rally extends Event{

    public Rally() {
        super("+1 to attacks on Close Combat and Circles Spaces.");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getCloseCombatMod() {
        return 1;
    }

    @Override
    public int getCircleAttackMod() {
        return 1;
    }
}
