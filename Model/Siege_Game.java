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

    
    
    
}
