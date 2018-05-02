package Model;

import Card_Events.Event;
import java.util.ArrayList;
import java.util.List;

public class Day implements Constants{
    private final int n_player_actions;
    private final List<Enemy_Attack> enemy_attack;
    private final Event event;
    
    public Day(int npa, List<Enemy_Attack> ea, Event a){        
        this.n_player_actions = npa;
        enemy_attack= new ArrayList<>(ea);
        event = a;
    }

    public List<Enemy_Attack> getEnemy_attack() {
        return enemy_attack;
    }

    public int getN_player_actions() {
        return n_player_actions;
    }
    
    public Event getEvent(){
        return event;
    }
    
    public void resolve(Game game) {
        getEvent().runEvent(game);
        game.enemyAttack(getEnemy_attack());
        game.setPlayerActions(getN_player_actions());
    }
    
    @Override
    public String toString() {
        StringBuilder aux=new StringBuilder();
        aux.append("Number Player Actions: ").append(n_player_actions).append("\n");
        for (int i = 0; i < enemy_attack.size(); i++) {
            aux.append(enemy_attack.get(i).toString()).append("\n");   
        }
        aux.append(event).append("\n");
        return aux.toString();
    }
}
