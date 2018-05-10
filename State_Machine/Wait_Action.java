package State_Machine;

import Model.*;

public class Wait_Action extends State_Adapter implements Constants{

    public Wait_Action(Game g){
        super(g);
    }
    @Override
    public States archers() {
        return new Wait_Archers(getGame());
    }

    @Override
    public States Tunnel() {
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
    public States Rally_Troops() {
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
    public States BuyAction() {
        return new Buy_One_Action(getGame());
    }

    
    

}
