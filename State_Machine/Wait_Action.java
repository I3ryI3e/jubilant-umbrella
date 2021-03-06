package State_Machine;

import Model.*;

public class Wait_Action extends State_Adapter implements Constants{
    public Wait_Action(Game g){super(g);}
    
    @Override
    public States archers() {
        return new Wait_Archers(getGame());
    }

    @Override
    public States tunnel() {
        return new Wait_Tunnel(getGame());
    }

    @Override
    public States boiling() {
        return new Wait_Boiling(getGame());
    }

    @Override
    public States closeCombat() {
        return new Close_Combat(getGame());
    }

    @Override
    public States rally_Troops() {
        return new Rally_Troops(getGame());
    }

    @Override
    public States coupure() {
        getGame().coupure();
        return this;
    }

    @Override
    public States sabotage() {
        getGame().sabotage();
        if(getGame().checkLoss())
            return new Game_Over(getGame());
        else
            return this;
    }

    @Override
    public States supplyRaid() {
        getGame().supplyRaid();
        if(getGame().checkLoss())
            return new Game_Over(getGame());
        else
            return this;
    }
    
    @Override
    public States endTurn() {
        if(getGame().endTurnLoss()){
            return new Game_Over(getGame());
        }
        getGame().endTurn();
        if(getGame().getGame_day()!= 3){
            return new Wait_Draw_Card(getGame());
        }
        return new Win_Game(getGame());
    }

    @Override
    public States buyAction() {
        return new Buy_One_Action(getGame());
    }
}
