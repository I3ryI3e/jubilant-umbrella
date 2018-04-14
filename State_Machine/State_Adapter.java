
package State_Machine;

import Model.Game;

public class State_Adapter implements States {
    private Game game;

    public State_Adapter(Game g){
        this.game=g;
    }
    public Game getGame(){
        return game;
    }
    @Override
    public States Draw_Card() {
        return this;
    }

    @Override
    public States Start_Game() {
        return this;
    }
    
   
    

    
}
