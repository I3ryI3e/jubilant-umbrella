package State_Machine;

import Model.Game;

public class Initial_State extends State_Adapter {

    public Initial_State(Game g) {
        super(g);
    }

    @Override
    public States Start_Game() {
        return new Wait_Draw_Card(getGame());
    }
    
    
}
