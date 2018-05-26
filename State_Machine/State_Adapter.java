package State_Machine;

import Model.*;

public class State_Adapter implements States, Constants {
    private Game game;

    public State_Adapter(Game g){this.game=g;}
    
    public Game getGame(){return game;}
    @Override
    public States Draw_Card(){return this;}
    @Override
    public States New_Game() {return this;}
    @Override
    public States rally_Troops() {return this;}
    @Override
    public States boiling() {return this;}
    @Override
    public States closeCombat() {return this;}
    @Override
    public States coupure() {return this;}
    @Override
    public States sabotage() {return this;}
    @Override
    public States supply() {return this;}
    @Override
    public States archers() {return this;}
    @Override
    public States tunnel() {return this;}
    @Override
    public States freeTunnelMovement() {return this;}
    @Override
    public States fastTunnelMovement() {return this;}
    @Override
    public States getInsideTunnelMovement() {return this;}
    @Override
    public States buyAction() {return this;}
    @Override
    public States buyAction(int opt) {return this;}
    @Override
    public States Apply_Action_Rules(Enemy_Attack ea) {return this;}
    @Override
    public States Apply_Rally_Rules(boolean check) {return this;}
    @Override
    public States returnWaitAction() {return this;}
    @Override
    public States endTurn() {return this;}
    @Override
    public States returnInitialState() {return this;}
}
