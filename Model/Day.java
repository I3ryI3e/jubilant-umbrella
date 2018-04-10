package Model;

public class Day {
    private final int n_player_actions;
    private final int enemy_attack;                                                   // 0 - None; 1- Ladder; 3- Ram; 5- Siege; 7-Sword
    private final Event action;
    
    public Day(int npa, int ea, Event a){        
        this.n_player_actions = npa;
        this.enemy_attack = ea;
        this.action = a;
    }
}
