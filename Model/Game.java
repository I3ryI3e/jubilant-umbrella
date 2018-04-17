package Model;

import Card_Events.Trebuchet_Attack;
import Model.Constants.Enemy_Attack;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Player player;
    private final Enemy enemy;
    private int game_day;
    private List<Card> deck;
    private List<Card> discard;

    public Game(){
        this.player= new Player();
        this.enemy= new Enemy();
        this.game_day = 0;
    }
    
    public int getGame_day(){
        return game_day;
    }
    
    public void setGame_day(int game_day){
        this.game_day = game_day;
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
    public void archers(int dice, Enemy_Attack enemy_mov) {
        if(discard.get(0).getDayX(getGame_day()) instanceof Day_Constant)
            dice += discard.get(0).getDayX(getGame_day()).have_atack_changes(enemy_mov);
        switch(enemy_mov){
            case LADDERS:
                if(dice > 2)
                    enemy.setLadder(enemy.getLadder()-1);
                break;
            case BATTERING_RAM:
                if(dice > 3)
                    enemy.setBattering_ram(enemy.getBattering_ram()-1);
                break;
            case SIEGE_TOWER:
                if(dice > 4)
                    enemy.setSiege_tower(enemy.getSiege_tower()-1);
                break;
        }
    }
}