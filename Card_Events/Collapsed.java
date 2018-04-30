package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Collapsed extends Event {

    public Collapsed() {
        super("Siege Tower removed from game if on starting space");
    }

    @Override
    public void runEvent(Siege_Game game) {
        game.removeSiegeFromGame();
    }
    
}
