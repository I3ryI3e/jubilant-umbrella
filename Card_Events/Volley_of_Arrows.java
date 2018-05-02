package Card_Events;

import Model.Game;

public class Volley_of_Arrows extends Event{
    public Volley_of_Arrows() {
        super("{VALLEY OF ARROWS}\n+1 to all attacks");
    }

    @Override
    public void runEvent(Game game) {
    }

    @Override
    public int getAllAttackMod() {
        return 1;
    }

   

}
