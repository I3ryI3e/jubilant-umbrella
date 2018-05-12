package Card_Events;

import Model.Game;

public class Guards_Distracted extends Event{
    public Guards_Distracted() {
        super("{GUARDS DISTRACTED}\n+1 to Sabotage action.\n+1 to Morale action.");
    }

    @Override
    public void runEvent(Game game) {}

    @Override
    public int getSabotageMod() {return 1;}

    @Override
    public int getMoraleMod() {return 1;}
}
