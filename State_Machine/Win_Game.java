package State_Machine;

import Model.Game;

public class Win_Game extends State_Adapter{    
    public Win_Game(Game g) {super(g);}

    @Override
    public States returnInitialState() {
        return new Initial_State(getGame());
    }
}
