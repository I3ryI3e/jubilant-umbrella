
package State_Machine;

import Model.Game;

public class WinGame extends State_Adapter{
    
    public WinGame(Game g) {
        super(g);
    }

    @Override
    public States returnInitialState() {
        return new Initial_State(getGame());
    }
    
    
}
