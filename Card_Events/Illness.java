package Card_Events;

import Model.Game;

public class Illness extends Event {
    public Illness() {
        super("{ILLNESS}\nReduce Morale by 1.\nReduce Supplies by 1.");
    }

    @Override
    public void runEvent(Game game) {
        game.DecreaseMoralEvent();
        game.DecreaseSuppliesEvent();
    }
}
