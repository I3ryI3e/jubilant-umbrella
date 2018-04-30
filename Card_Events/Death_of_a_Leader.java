package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Death_of_a_Leader extends Event{

    public Death_of_a_Leader() {
        super("{DEATH OF A LEADER}\nReduce morale by 1.");
    }

    @Override
    public void runEvent(Siege_Game game) {
        game.ReduceMoralEvent();
    }
    
}
