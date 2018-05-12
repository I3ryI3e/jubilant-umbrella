package Card_Events;

import Model.Game;

public class Gate_Fortified extends Event {
    public Gate_Fortified() {
        super("{GATE FORTIFIED}\n+1 to attacks on Battering Rams.");
    }

    @Override
    public void runEvent(Game game) {}

    @Override
    public int getRamMod() {return 1;}
}
