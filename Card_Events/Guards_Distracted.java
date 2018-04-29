package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Guards_Distracted extends Event{

    public Guards_Distracted() {
        super("+1 to Sabotage action.\n+1 to Morale action.");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getSabotageMod() {
        return 1;
    }

    @Override
    public int getMoraleMod() {
        return 1;
    }
}
