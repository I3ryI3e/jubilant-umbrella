package Model;

import Board.Enemy;
import Board.Player;
import Cards.*;
import Model.Constants.Enemy_Attack;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {
    private Player player;
    private Enemy enemy;
    private int game_day;
    private List<Card> deck;
    private List<Card> discard;

    public Game(){
        deck = new ArrayList<>();
        discard = new ArrayList<>();
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
        this.player= new Player();
        this.enemy= new Enemy();
        this.game_day = 0;
        deck.add(0,new Card1());
        deck.add(1,new Card2());
        deck.add(2,new Card3());
        deck.add(3,new Card4());
        deck.add(4,new Card5());
        deck.add(5,new Card6());
        deck.add(6,new Card7());
        Collections.shuffle(deck);
    }
    public void archers(Enemy_Attack enemy_mov) { // TODO!! 
        int dice = (int) (Math.random()*5+1);       //FAZER CLASSE DADO??
        switch(enemy_mov){                                  // NOT QUITE RIGHT! DICE MODIFICATIONS DON'T ACCOUNT FOR POSITION
            case LADDER:
        {
            try {
                dice += discard.get(0).getDayX(game_day).getEvent().getLadderMod() + getEnemy().getLadderPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent());
            } catch (MyException ex) {
                dice += discard.get(0).getDayX(game_day).getEvent().getLadderMod();
            }
        }
        {
            try {
                if(dice > getEnemy().getLadderStrength())
                    enemy.goBackwardLadder();
            } catch (MyException ex) {}
        }
                break;
            case BATTERING_RAM:
        {
            try {
                dice += discard.get(0).getDayX(game_day).getEvent().getRamMod() + getEnemy().getBatteringRamPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent());
            } catch (MyException ex) {
                dice += discard.get(0).getDayX(game_day).getEvent().getRamMod();
            }
        }
        {
            try {
                if(dice > getEnemy().getBatteringRamStrength())
                    enemy.goBackwardBatteringRam();
            } catch (MyException ex) {}
        }
                break;
            case SIEGE_TOWER:
        {
            try {
                dice += discard.get(0).getDayX(game_day).getEvent().getSiegeMod() + getEnemy().getSiegeTowerPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent());
            } catch (MyException ex) {
                dice += discard.get(0).getDayX(game_day).getEvent().getSiegeMod();
            }
        }
        {
            try {
                if(dice > getEnemy().getSiegeTowerStrength())
                    enemy.goBackwardSiegeTower();
            } catch (MyException ex) {}
        }
                break;
        }
    }

    public void removeSiegeFromGame() {
        enemy.removeSiegeFromGame();
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        aux.append(player);
        aux.append(enemy);
        for (int i = 0; i < deck.size(); i++) {
            aux.append(deck.get(i).toString());
        }
        return aux.toString();
    }

    public void drawAndResolveCard() {
        drawCard();
        resolveCard();
    }

    private void drawCard() {
        discard.add(0, deck.remove(0));
    }

    private void resolveCard() {
        discard.get(0).resolve(getGame_day(), this);
    }

    void setPlayerActions(int n_player_actions) {
        getPlayer().setActions(n_player_actions);
    }

    void enemyAttack(List<Enemy_Attack> enemy_attack) {
        for(int i=0;i<enemy_attack.size();i++){
            getEnemy().enemyAttack(enemy_attack.get(i));
        }
    }
}