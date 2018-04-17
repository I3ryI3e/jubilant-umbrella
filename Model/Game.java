package Model;

import Card_Events.Trebuchet_Attack;
import Model.Constants.Enemy_Attack;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Player player;
    private final Enemy enemy;
    private List<Card> deck;
    private List<Card> discard;

    public Game(){
        this.player= new Player();
        this.enemy= new Enemy();
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
    private Card create_card_1(){
        Card card = new Card(1);
        List <Enemy_Attack> aux = new ArrayList<>();
        aux.add(Enemy_Attack.NONE);
        Day day = new Day(3,aux,new Trebuchet_Attack());
        card.addDay(day);
        day= new Day(2,aux,new Trebuchet_Attack());
        card.addDay(day);
        day = new Day(1,aux,new Trebuchet_Attack());
        card.addDay(day);
        return card;
    }
    
    public void setup() {
        deck.add(create_card_1());
        
    }
}