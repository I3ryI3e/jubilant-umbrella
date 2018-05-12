package Card_Events;

import Model.Game;

public class Iron_Shields extends Event {
    public Iron_Shields() {
        super("{IRON SHIELDS}\n-1 to attacks on Siege Tower.");
    }

    @Override
    public void runEvent(Game game) {}

    @Override
    public int getSiegeMod() {return -1;}
}
