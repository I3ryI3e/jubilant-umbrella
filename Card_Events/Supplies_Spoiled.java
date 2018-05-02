
package Card_Events;

import Model.Game;

public class Supplies_Spoiled extends Event {

    public Supplies_Spoiled() {
        super("{SUPPLIES SPOILED}\nReduce Supplies by 1");
    }

    @Override
    public void runEvent(Game game) {
        game.DecreaseSuppliesEvent();
    }

    
    
}
