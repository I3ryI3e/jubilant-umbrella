package Model;

import Model.Constants.Enemy_Attack;
import java.util.ArrayList;
import java.util.List;

public class Day {
    private final int n_player_actions;
    private final ArrayList<Enemy_Attack> enemy_attack;                                                 
    private final ArrayList<Event> action;
    
    public Day(int npa, List <Enemy_Attack> ea, List <Event> a){        
        this.n_player_actions = npa;
        enemy_attack= new ArrayList<>(ea);
        action = new ArrayList<>(a);
    }
}
