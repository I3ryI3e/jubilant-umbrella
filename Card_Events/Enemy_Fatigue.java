package Card_Events;

import Model.Game;

public class Enemy_Fatigue extends Event {
    public Enemy_Fatigue() {
        super("{ENEMY FATIGUE}\n+1 to Coupure, Raid and Sabotage actions.");
    }

    @Override
    public void runEvent(Game game) {}

    @Override
    public int getCoupureMod() {return 1;}

    @Override
    public int getRaidMod() {return 1;}

    @Override
    public int getSabotageMod() {return 1;}
}
