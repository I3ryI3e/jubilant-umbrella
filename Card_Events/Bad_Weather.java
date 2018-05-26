package Card_Events;

import Model.Game;
import Model.MyException;

public class Bad_Weather extends Event {
    public Bad_Weather() {
        super("{BAD WEATHER}\nOnly Raid and Sabotage actions allowed this turn.");
    }

    @Override
    public void runEvent(Game game) { game.setSabAndRaidStateActive(true);}
}
