
package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Cover_of_Darkness extends Event {

    public Cover_of_Darkness() {
        super("{COVER OF DARKNESS}\n+1 to Raid and Sabotage actions.");
    }

    @Override
    public void runEvent(Siege_Game game) {
    }

    @Override
    public int getRaidMod() {
        return 1;
    }

    @Override
    public int getSabotageMod() {
        return 1;
    }
}
