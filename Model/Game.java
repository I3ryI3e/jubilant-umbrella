package Model;

import Board.Enemy;
import Board.Player;
import Cards.*;
import Model.Constants.Enemy_Attack;

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
    
    public void setup() {
        deck.add(0,new Card1());
        deck.add(1,new Card2());
        deck.add(2,new Card3());
        deck.add(3,new Card4());
        deck.add(4,new Card5());
        deck.add(5,new Card6());
        deck.add(6,new Card7());
    }
    public void archers(Enemy_Attack enemy_mov) { // TODO!! 
        int dice = (int) (Math.random()*5+1);       //FAZER CLASSE DADO??
        switch(enemy_mov){                                  // NOT QUITE RIGHT! DICE MODIFICATIONS DON'T ACCOUNT FOR POSITION
            case LADDERS:
                dice += discard.get(0).getDayX(game_day).getEvent().getLadderMod();
                if(dice > 2)
                    enemy.goBackwardLadder();
                break;
            case BATTERING_RAM:
                dice += discard.get(0).getDayX(game_day).getEvent().getRamMod();
                if(dice > 3)
                    enemy.goBackwardBatteringRam();
                break;
            case SIEGE_TOWER:
                dice += discard.get(0).getDayX(game_day).getEvent().getSiegeMod();
                if(dice > 4)
                    enemy.goBackwardSiegeTower();
                break;
        }
    }

    public void removeSiegeFromGame() {
        enemy.removeSiegeFromGame();
    }
    
}