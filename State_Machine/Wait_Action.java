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
    public States endTurn() { // TODO check if this is ok!
        if(getGame().getGame_day()!= 2){
            getGame().endTurn();
            return new Wait_Draw_Card(getGame());
        }
        return new Game_Over(getGame());
    }

    @Override
    public States closeCombat() {
        getGame().closeCombat();
        if(getGame().getPlayer().checkLoss())
            return new Game_Over(getGame());
        else
            return this;
    }
    

}
