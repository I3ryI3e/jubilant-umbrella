package State_Machine;

import Model.Game;

public class Game_Over extends State_Adapter{
    public Game_Over(Game g) {super(g);}

    @Override
    public States returnInitialState() {
        return new Initial_State(getGame());
    }
}
