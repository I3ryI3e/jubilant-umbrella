package Model;

import Board.Enemy;
import Board.Player;
import Cards.*;
import Model.Constants.Enemy_Attack;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game implements Serializable{
    private Player player;
    private Enemy enemy;
    private int game_day;
    private List<Card> deck;
    private List<Card> discard;
    private boolean canUseSupllyToOneMoreAction;
    private StringBuffer textToOutput;

    public Game(){
        this.player= new Player();
        this.enemy= new Enemy();
        this.deck = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.canUseSupllyToOneMoreAction=true;
        this.textToOutput = new StringBuffer();
    }
    
    public int getGame_day(){
        return game_day;
    }
    public boolean getCanUseSupply(){
        return canUseSupllyToOneMoreAction;
    }
    public void changeCanUseSupply(){
        this.canUseSupllyToOneMoreAction = !this.canUseSupllyToOneMoreAction;
    }
    public String getTextToOutput(){
        String aux = textToOutput.toString();
        textToOutput.delete(0, textToOutput.length());
        return aux;
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
    public void archers(Enemy_Attack ea) { // TODO!! 
        int dice = (int) (Math.random()*5+1);       //FAZER CLASSE DADO??
        int bonus = 0;
        textToOutput.append("Dado: ").append(dice);
        switch(ea){                                  
            case LADDER:
            try {
                bonus= discard.get(0).getDayX(game_day).getEvent().getLadderMod()+ discard.get(0).getDayX(game_day).getEvent().getAllAttackMod() + getEnemy().getLadderPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent());
            } catch (MyException ex) {
                bonus = discard.get(0).getDayX(game_day).getEvent().getLadderMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice+bonus > getEnemy().getLadderStrength()){
                    enemy.goBackwardLadder();
                    textToOutput.append("\nVictory, Ladder is going to backout");
                }
            } catch (MyException ex) {}
            break;
            case BATTERING_RAM:
            try {
                bonus = discard.get(0).getDayX(game_day).getEvent().getRamMod() + discard.get(0).getDayX(game_day).getEvent().getAllAttackMod()  + getEnemy().getBatteringRamPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent());
            } catch (MyException ex) {
                bonus = discard.get(0).getDayX(game_day).getEvent().getRamMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > getEnemy().getBatteringRamStrength()){
                    enemy.goBackwardBatteringRam();
                    textToOutput.append("\nVictory, Battering Ram is going to backout");
                }
            } catch (MyException ex) {}
            break;
            case SIEGE_TOWER:
            try {
                bonus = discard.get(0).getDayX(game_day).getEvent().getSiegeMod() + discard.get(0).getDayX(game_day).getEvent().getAllAttackMod() + getEnemy().getSiegeTowerPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent());
            } catch (MyException ex) {
                bonus = discard.get(0).getDayX(game_day).getEvent().getSiegeMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > getEnemy().getSiegeTowerStrength()){
                    enemy.goBackwardSiegeTower();
                    textToOutput.append("\nVictory, Siege Tower is going to backout");
                }
            } catch (MyException ex) {}
            break;
        }
        player.decreasePlayerActions();
    }
    public void boilling(Enemy_Attack ea) {
        int dice = (int) (Math.random()*5+1);
        int bonus =0;
        textToOutput.append("Dado: ").append(dice);
        switch(ea){                                  
            case LADDER:
            try {
                bonus = discard.get(0).getDayX(game_day).getEvent().getLadderMod()+ discard.get(0).getDayX(game_day).getEvent().getCircleAttackMod() + getEnemy().getLadderPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent()) +1;
            } catch (MyException ex) {
                bonus = discard.get(0).getDayX(game_day).getEvent().getLadderMod() +1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus  > getEnemy().getLadderStrength()){
                    enemy.goBackwardLadder();
                    textToOutput.append("\nVictory, Ladder is going to backout");
                }
            } catch (MyException ex) {}
            break;
            case BATTERING_RAM:
            try {
                bonus = discard.get(0).getDayX(game_day).getEvent().getRamMod() + discard.get(0).getDayX(game_day).getEvent().getCircleAttackMod()  + getEnemy().getBatteringRamPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent())+1;
            } catch (MyException ex) {
                bonus = discard.get(0).getDayX(game_day).getEvent().getRamMod()+1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus  > getEnemy().getBatteringRamStrength()){
                    enemy.goBackwardBatteringRam();
                    textToOutput.append("\nVictory, Battering Ram is going to backout");
                }
            } catch (MyException ex) {}
            break;
            case SIEGE_TOWER:
            try {
                bonus = discard.get(0).getDayX(game_day).getEvent().getSiegeMod() + discard.get(0).getDayX(game_day).getEvent().getCircleAttackMod() + getEnemy().getSiegeTowerPosition().getPositionModifier(discard.get(0).getDayX(game_day).getEvent())+1;
            } catch (MyException ex) {
                bonus = discard.get(0).getDayX(game_day).getEvent().getSiegeMod()+1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > getEnemy().getSiegeTowerStrength()){
                    enemy.goBackwardSiegeTower();
                    textToOutput.append("\nVictory, Ladder is going to backout");
                }
            } catch (MyException ex) {}
            break;
        }
        if(bonus < 2){
            player.decreaseMorale();
        }
        player.decreasePlayerActions();
    }
    public void removeSiegeFromGame() {
        enemy.removeSiegeFromGame();
    }
    public void drawAndResolveCard()throws MyException {
        drawCard();
        resolveCard();
    }
    private void drawCard() {
        discard.add(0, deck.remove(0));
    }
    private void resolveCard()throws MyException {
        player.doEnemyCheckLine();
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
    public boolean checkLoss() {
        return (getPlayer().checkLoss() || getEnemy().isNumEnemyInCloseCombat(3));
    }
    public boolean TwoEnemyLine() {
        return (getEnemy().isNumEnemyInCloseCombat(2));
    }
    public void DecreaseMoralEvent() {
        getPlayer().decreaseMorale();
    }
    public String drawBoards() {
        StringBuilder aux = new StringBuilder();
        aux.append(getPlayer()).append("\n\n").append(getEnemy()).append("\n\n");
        return aux.toString();
    }
    public String drawCardDay() {
        return discard.get(0).getDayX(game_day).toString();
    }
    public void endTurn() {
        if(deck.isEmpty()){
            reputAllCardsIntoDeck();
            setGame_day(getGame_day()+1);
        }
        this.canUseSupllyToOneMoreAction=true;
    }
    private void reputAllCardsIntoDeck() {
        for (int i = 0; i < discard.size(); i++) {
            deck.add(i,discard.get(discard.size()-1-i));
        }
        discard.clear();
    }
    public void DecreaseSuppliesEvent() {
        getPlayer().decreaseSupplies();
    }
    public void addTrebuchetEvent() {
        getEnemy().increaseNumberOfTrebuchet();
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

    boolean playerStillHasActionsLeft() {
        return player.playerStillHasActionsLeft();
    }
}