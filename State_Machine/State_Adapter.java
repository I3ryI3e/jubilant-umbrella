package State_Machine;

import Model.*;

public class State_Adapter implements States, Constants {
    private Game game;

    public State_Adapter(Game g){
        this.game=g;
    }
    public Game getGame(){return game;}
    @Override
    public States Draw_Card() {return this;}
    @Override
    public States New_Game() {return this;}
    @Override
    public States setActions(int na) {return this;}
    @Override
    public States Rally_Troops() {return this;}
    @Override
    public States Boiling() {return this;}
    @Override
    public States Tunnel() {return this;}
    @Overridex
    public States Apply_Action_Rules(Enemy_Attack ea) {return this;}
    @Override
    public States archers() {return this;}
    @Override
    public States returnWaitAction() {return this;}
    @Override
    public States ReduceMoralEvent() {return this;}
    
}
