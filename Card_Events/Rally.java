package Card_Events;

import Model.Game;

public class Rally extends Event{
    public Rally() {
        super("{RALLY}\n+1 to attacks on Close Combat and Circles Spaces.");
    }

    @Override
    public void runEvent(Game game) {}

    @Override
    public int getCloseCombatMod() {return 1;}

    @Override
    public int getCircleAttackMod() {return 1;}
}
