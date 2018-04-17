package State_Machine;

import Model.*;

public class State_Adapter implements States, Constants {
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
    @Override
    public States archers(int dice, Enemy_Attack enemy_mov){
        return this;
    }

    @Override
    public States setActions(int na) {
        return this;
    }
    
}
