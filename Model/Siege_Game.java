package Model;

import State_Machine.Initial_State;
import State_Machine.State_Adapter;

public class Siege_Game {
    private Game game;
    private State_Adapter state;

    public Siege_Game(){
        this.game = new Game();
        setState(new Initial_State(game));
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public void setState(State_Adapter state) {
        this.state = state;
    }

    public Game getGame() {
        return game;
    }

    public State_Adapter getState() {
        return state;
    }

    public boolean can_archers(){
        if(game.getEnemy().getLadder() == game.getEnemy().getBattering_ram() && game.getEnemy().getSiege_tower() == 4)
            return false;
    }
    
    public void archers(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
