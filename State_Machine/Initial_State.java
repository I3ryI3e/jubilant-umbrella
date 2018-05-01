package State_Machine;

import Model.Game;

public class Initial_State extends State_Adapter {

    public Initial_State(Game g) {
        super(g);
    }

    @Override
    public States New_Game() {
        getGame().setup();
        return new Wait_Draw_Card(getGame());
    }
    
    
    
}
