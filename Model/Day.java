package Model;

import Card_Events.Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Day implements Constants, Serializable{
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
    
    public void resolve(Game game) throws MyException {
        try {
            getEvent().runEvent(game);
        } catch (MyException ex) {
            game.enemyAttack(getEnemy_attack());
            game.setPlayerActions(getN_player_actions());
            throw new MyException();
        }
        game.enemyAttack(getEnemy_attack());
        game.setPlayerActions(getN_player_actions());
    }
    
    @Override
    public String toString() {
        StringBuilder aux=new StringBuilder();
        aux.append("{CARD}\nCard number actions: ").append(n_player_actions).append("\n");
        aux.append("Enemy Attacks: ");
        for (int i = 0; i < enemy_attack.size(); i++) {
            aux.append(enemy_attack.get(i).toString()).append("\n");   
        }
        aux.append(event).append("\n");
        return aux.toString();
    }
}
