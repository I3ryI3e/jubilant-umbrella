
package State_Machine;

import Model.Game;

public class Only_Raid_and_Sab_State extends State_Adapter{
    
    public Only_Raid_and_Sab_State(Game g) {
        super(g);
    }

    @Override
    public States endTurn() {
         if(getGame().getGame_day()!= 2){
            getGame().endTurn();
            return new Wait_Draw_Card(getGame());
        }
        return new Game_Over(getGame());
    }
    
    
}
