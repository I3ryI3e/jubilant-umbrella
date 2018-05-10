
package State_Machine;

import Model.Game;

public class Only_Raid_and_Sab_State extends State_Adapter{
    
    public Only_Raid_and_Sab_State(Game g) {
        super(g);
    }

    @Override
    public States endTurn() {
          if(getGame().victoryOrLoss()){
            return new Game_Over(getGame());
        }
        getGame().endTurn();
        if(getGame().getGame_day()!= 3){
            return new Wait_Draw_Card(getGame());
        }
        return new WinGame(getGame());
    }

    @Override
    public States sabotage() {
        getGame().sabotage();
        if(getGame().getPlayer().checkLoss())
            return new Game_Over(getGame());
        else
            return this;
    }

    @Override
    public States supply() {
        getGame().supply();
        if(getGame().getPlayer().checkLoss())
            return new Game_Over(getGame());
        else
            return this;
    }

    @Override
    public States BuyAction() {
        return new Buy_One_Action(getGame());
    }
    
    
    
}
