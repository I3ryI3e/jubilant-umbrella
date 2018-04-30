package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Bad_Weather extends Event {

    public Bad_Weather() {
        super("{BAD WEATHER}\nOnly Raid and Sabotage actions allowed this turn.");
    }

    @Override
    public void runEvent(Siege_Game game) {
        //TODO
    }
    
}
