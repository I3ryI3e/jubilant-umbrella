package Model;

import Model.Constants.Enemy_Attack;
import java.util.ArrayList;
import java.util.List;

public class Day {
    private final int n_player_actions;
    private final List<Enemy_Attack> enemy_attack;
    private final Event event;
    
    public Day(int npa, List<Enemy_Attack> ea, Event a){        
        this.n_player_actions = npa;
        enemy_attack= new ArrayList<>(ea);
        event = a;
    }
}
