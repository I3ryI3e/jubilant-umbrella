package Card_Events;

import Model.Game;

public class Collapsed extends Event {
    public Collapsed() {
        super("{COLLAPSED}\nSiege Tower removed from game if on starting space");
    }

    @Override
    public void runEvent(Game game) {game.removeSiegeFromGame();}
}
