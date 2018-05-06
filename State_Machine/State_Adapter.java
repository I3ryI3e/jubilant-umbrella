package State_Machine;

import Model.*;

public class State_Adapter implements States, Constants {
    private Game game;

    public State_Adapter(Game g){
        this.game=g;
    }
    public Game getGame(){return game;}
    @Override
    public States Draw_Card()throws MyException {return this;}
    @Override
    public States New_Game() {return this;}
    @Override
    public States setActions(int na) {return this;}
    @Override
    public States Rally_Troops() {return this;}
    @Override
    public States boiling() {return this;}
    @Override
    public States Tunnel() {return this;}
    @Override
    public States Apply_Action_Rules(Enemy_Attack ea) {return this;}
    @Override
    public States archers() {return this;}
    @Override
    public States returnWaitAction() {return this;}
    @Override
    public States checkLossAnd2Enemy() {
        if(getGame().checkLoss())
            return new Game_Over(getGame());
        if(getGame().TwoEnemyLine())
            return new Two_Enemy_Attack(getGame());
        return this;
    }

    @Override
    public States endTurn() {
        return this;
    }
    

}
