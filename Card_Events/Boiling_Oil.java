package Card_Events;

import Model.Game;

public class Boiling_Oil extends Event {
    public Boiling_Oil() {
        super("{BOILING OIL}\n+2 to attack on enemies on circle spaces.");
    }

    @Override
    public void runEvent(Game game) {}

    @Override
    public int getCircleAttackMod() {return 2;}
}
