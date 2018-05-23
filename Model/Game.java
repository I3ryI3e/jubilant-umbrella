package Model;

import Board.Close_Combat_Square;
import Board.Enemy;
import Board.Player;
import Card_Events.Bad_Weather;
import Card_Events.Event;
import Cards.*;
import Model.Constants.Enemy_Attack;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game implements Serializable, Constants{
    private Player player;
    private Enemy enemy;
    private int game_day;
    private List<Card> deck;
    private List<Card> discard;
    private StringBuffer textToOutput;
    private boolean canUseSupllyOrMoraleToOneMoreAction;
    private boolean canUseBoiling;
    private boolean canUseFreeMovement;

    public Game(){
        this.player= new Player();
        this.enemy= new Enemy();
        this.deck = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.canUseSupllyOrMoraleToOneMoreAction=true;
        this.canUseFreeMovement=true;
        this.canUseBoiling=true;
        this.textToOutput = new StringBuffer();
    }
    
    public int getGame_day(){return game_day;}
    
    public boolean getCanUseSupplyOrMorale(){return canUseSupllyOrMoraleToOneMoreAction;}
    
    public void changeCanUseSupply(){this.canUseSupllyOrMoraleToOneMoreAction = !this.canUseSupllyOrMoraleToOneMoreAction;}
    
    public boolean canUseBoiling(){return canUseBoiling;}
    
    public void changeUseBoiling(){this.canUseBoiling= !this.canUseBoiling;}
    
    public String getTextToOutput(){
        String aux = textToOutput.toString();
        textToOutput.delete(0, textToOutput.length());
        return aux;
    }
    
    public void setGame_day(int game_day){this.game_day = game_day;}
    
    public Player getPlayer() {return player;}
    
    public Enemy getEnemy() {return enemy;}
    
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
    private Event getActiveEvent(){
        return discard.get(0).getDayX(game_day).getEvent();
    }
    
    public void archers(Enemy_Attack ea) { 
        int dice = Dice.rollDice();
        int bonus = 0;
        Event event = getActiveEvent();
        textToOutput.append("Dado: ").append(dice);
        switch(ea){                                  
            case LADDER:
            try {
                bonus= event.getLadderMod()+ event.getAllAttackMod() + getEnemy().getPositionModifier(ea,event);
            } catch (MyException ex) {
                bonus = event.getLadderMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice+bonus > getEnemy().getLadderStrength()){
                    enemy.goBackwardLadder();
                    textToOutput.append("\nVictory, Ladder is going to backout!");
                }
            } catch (MyException ex) {}
            break;
            case BATTERING_RAM:
            try {
                bonus = event.getRamMod() + event.getAllAttackMod()  + getEnemy().getPositionModifier(ea,event);
            } catch (MyException ex) {
                bonus = event.getRamMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > getEnemy().getBatteringRamStrength()){
                    enemy.goBackwardBatteringRam();
                    textToOutput.append("\nVictory, Battering Ram is going to backout!");
                }
            } catch (MyException ex) {}
            break;
            case SIEGE_TOWER:
            try {
                bonus = event.getSiegeMod() + event.getAllAttackMod() + getEnemy().getPositionModifier(ea,event);
            } catch (MyException ex) {
                bonus = event.getSiegeMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > getEnemy().getSiegeTowerStrength()){
                    enemy.goBackwardSiegeTower();
                    textToOutput.append("\nVictory, Siege Tower is going to backout!");
                }
            } catch (MyException ex) {}
            break;
        }
        player.decreasePlayerActions();
    }
    
    public void boiling(Enemy_Attack ea) {
        int dice = Dice.rollDice();
        int bonus = 0;
        Event event = getActiveEvent();
        textToOutput.append("Dado: ").append(dice);
        switch(ea){                                  
            case LADDER:
            try {
                bonus = event.getLadderMod()+ event.getCircleAttackMod() + getEnemy().getPositionModifier(ea,event) +1;
            } catch (MyException ex) {
                bonus = event.getLadderMod() +1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus  > getEnemy().getLadderStrength()){
                    enemy.goBackwardLadder();
                    textToOutput.append("\nVictory, Ladder is going to backout!");
                }
            } catch (MyException ex) {}
            break;
            case BATTERING_RAM:
            try {
                bonus = event.getRamMod() + event.getCircleAttackMod()  + getEnemy().getPositionModifier(ea,event)+1;
            } catch (MyException ex) {
                bonus = discard.get(0).getDayX(game_day).getEvent().getRamMod()+1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus  > getEnemy().getBatteringRamStrength()){
                    enemy.goBackwardBatteringRam();
                    textToOutput.append("\nVictory, Battering Ram is going to backout!");
                }
            } catch (MyException ex) {}
            break;
            case SIEGE_TOWER:
            try {
                bonus = event.getSiegeMod() + event.getCircleAttackMod() + getEnemy().getPositionModifier(ea,event)+1;
            } catch (MyException ex) {
                bonus = event.getSiegeMod()+1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > getEnemy().getSiegeTowerStrength()){
                    enemy.goBackwardSiegeTower();
                    textToOutput.append("\nVictory, Ladder is going to backout!");
                }
            } catch (MyException ex) {}
            break;
        }
        if(dice == 1 && bonus < 2){
            player.decreaseMorale();
        }
        player.decreasePlayerActions();
        canUseBoiling=false;
    }
    
    public void closeCombat(Enemy_Attack ea) {
        int dice = Dice.rollDice();
        Event event = getActiveEvent();
        int bonus =event.getAllAttackMod() + event.getCloseCombatMod();
        textToOutput.append("Dado: ").append(dice).append("\nBonus to dice: ");
        switch(ea){
            case LADDER:
                try {
                    if(getEnemy().getLadderPosition() instanceof Close_Combat_Square){
                        if( dice+bonus > CLOSE_COMBAT_POSITION_POWER){
                            getEnemy().goBackwardLadder();
                            textToOutput.append(bonus).append("\nVictory, Ladder is going to backout!\n");
                            player.decreasePlayerActions();
                        }
                    }
                } catch (MyException ex) {}
                break;
            case BATTERING_RAM:
                try{
                    if(getEnemy().getBatteringRamPosition() instanceof Close_Combat_Square){
                        if( dice+bonus > CLOSE_COMBAT_POSITION_POWER){
                            getEnemy().goBackwardBatteringRam();
                            textToOutput.append(bonus).append("\nVictory, Battering Ram is going to backout!\n");
                            player.decreasePlayerActions();
                        }
                    }
                } catch (MyException ex) {} 
                break;
            case SIEGE_TOWER:
                try{
                    if(getEnemy().getSiegeTowerPosition() instanceof Close_Combat_Square){
                        if( dice+bonus > CLOSE_COMBAT_POSITION_POWER){
                            getEnemy().goBackwardSiegeTower();
                            textToOutput.append(bonus).append("\nVictory, Siege Tower is going to backout!\n");
                            player.decreasePlayerActions();
                        }
                    }
                } catch (MyException ex) {}
                break;
        }
        player.decreasePlayerActions();
    }
    
    public void rally(boolean DRMplusOne) {
        int dice = Dice.rollDice();
        int bonus = getActiveEvent().getMoraleMod();
        if(DRMplusOne){
            player.decreaseSupplies();
            bonus += 1;
        }
        textToOutput.append("Dado: ").append(dice).append("\nBonus to Dice: ").append(bonus).append("\n");
        if(dice + bonus >= 5){
            getPlayer().raiseMorale();
            textToOutput.append("\nVictory, rally troops successfully done!");
        }
        player.decreasePlayerActions();
    }
    
    public void coupure(){
        int dice = Dice.rollDice();
        int bonus = getActiveEvent().getCoupureMod();
        textToOutput.append("Dado: ").append(dice).append("\nBonus to Dice: ").append(bonus).append("\n");
        if(dice + bonus >= 5){
            getPlayer().raiseWall();
            textToOutput.append("\nVictory, coupure successfully done!");
        }
        player.decreasePlayerActions();
    }
    
    public void sabotage() {
        int dice = Dice.rollDice();
        int bonus = getActiveEvent().getSabotageMod();
        textToOutput.append("Dado: ").append(dice).append("\nBonus to Dice: ").append(bonus).append("\n");
        if(dice + bonus >= 5){
            getEnemy().removeTrebutchet();
            textToOutput.append("\nVictory, sabotage successfully done!");
        }else if(dice == 1){
            getPlayer().soldierCaptured();
            textToOutput.append("\nYour soldier as been captured!");
        }
        player.decreasePlayerActions();
    }
    
    public void supply() {
        int dice = Dice.rollDice();
        int bonus = getActiveEvent().getRaidMod();
        textToOutput.append("Dado: ").append(dice).append("\nBonus to Dice: ").append(bonus).append("\n");
        if(dice + bonus == 6){
            getPlayer().addRaided_supplies(2);
            textToOutput.append("\nVictory, 2 supplies successfully done!");
        }else if(dice == 1){
            getPlayer().soldierCaptured();
            textToOutput.append("\nYour soldier as been captured!");
        }else if(!(dice + bonus == 2)){
            getPlayer().addRaided_supplies(1);
            textToOutput.append("\nVictory, 1 supply successfully done!");
        }
        player.decreasePlayerActions();
    }
    
    public void removeSiegeFromGame() {enemy.removeSiegeFromGame();}
    
    public void drawAndResolveCard()throws MyException {
        drawCard();
        resolveCard();
    }
    
    private void drawCard() {discard.add(0, deck.remove(0));}
    
    private void resolveCard()throws MyException {
        textToOutput.append(player.doEnemyCheckLine(Dice.rollDice()));
        discard.get(0).resolve(getGame_day(), this);
    }
    
    void setPlayerActions(int n_player_actions) {getPlayer().setActions(n_player_actions);}
    
    void enemyAttack(List<Enemy_Attack> enemy_attack) {
        for(int i=0;i<enemy_attack.size();i++){
            getEnemy().enemyAttack(enemy_attack.get(i), this);
        }
    }
    
    public boolean checkLoss() {return (getPlayer().checkLoss() || getEnemy().isNumEnemyInCloseCombat(3));}
    
    public boolean TwoEnemyLine() {return (getEnemy().isNumEnemyInCloseCombat(2));}
    
    public void DecreaseMoralEvent() {getPlayer().decreaseMorale();}
    
    public String drawBoards() {
        StringBuilder aux = new StringBuilder();
        aux.append(getPlayer()).append("\n\n").append(getEnemy()).append("\n\n");
        return aux.toString();
    }
    
    public String drawCardDay() {return discard.get(0).printDayX(game_day, discard.size());}
    
    public void endTurn() {
        if(deck.isEmpty()){
            textToOutput.append(">>End of day ").append(getGame_day()+1).append("<<");
            DecreaseSuppliesEvent();
            endOfDayPhaseTunnel();
            reputAllCardsIntoDeck();
            setGame_day(getGame_day()+1);
            if(getGame_day()!=4)
                textToOutput.append("\n>>Day ").append(getGame_day()+1).append(" is starting!<<\n");
        }
        this.canUseSupllyOrMoraleToOneMoreAction=true;
        this.canUseBoiling=true;
        this.canUseFreeMovement=true;
    }
    
    private void reputAllCardsIntoDeck() {
        for (int i = 0; i < discard.size(); i++) {
            deck.add(i,discard.get(discard.size()-1-i));
        }
        discard.clear();
        Collections.shuffle(deck);
    }
    
    public void DecreaseSuppliesEvent() {getPlayer().decreaseSupplies();}
    
    public void addTrebuchetEvent() {getEnemy().increaseNumberOfTrebuchet();}

    boolean playerStillHasActionsLeft() {return player.playerStillHasActionsLeft();}

    public boolean canUseTunnelMovement() {return player.canUseTunnelMovement();}

    public boolean automaticTunnelMovement() {
        if(player.automaticTunnelMovement()){
            canUseFreeMovement = false;
            return true;
        }
        return false;
    }

    public boolean fastTunnelMovement() {return player.fastTunnelMovement();}

    public boolean getInsidetunnelMovement() {
        if(player.getInsideTunnelMovement()){
            this.canUseFreeMovement=false;
            return true;
        }
        return false;
    }

    boolean enemiesOnCloseCombatPosition() {return enemy.anyEnemyOnCloseCombat();}

    public int numberOfActionsAvailable() {return player.getActions();}

    public void buyAction(int opt) {
        player.buyAction(opt);
        changeCanUseSupply();
    }

    boolean ladderOnStartingPosition() {return enemy.ladderOnStartingPosition();}

    boolean batteringRamOnStartingPosition() {return enemy.batteringRamOnStartingPosition();}

    boolean siegeTowerOnStartingPosition() {return enemy.siegeTowerOnStartingPosition();}

    boolean getCanMakeFreeMove() {return canUseFreeMovement;}

    public void enemyCheckLine() {player.doEnemyCheckLine(Dice.rollDice());}

    public boolean victoryOrLoss() {return (player.victoryOrLoss() || enemy.victoryOrLoss());}

    public void endOfDayPhaseTunnel() {textToOutput.append(player.endOfDayPhaseTunnel());}

    public boolean isRaidAndSabEventActive() {return discard.get(0).getDayX(game_day).getEvent() instanceof Bad_Weather;}
    
    public boolean siegeTowerExists() {return enemy.siegeTowerExists();}
    public boolean existsTrebuchet() {return enemy.getTrebutchet()>0;}
    
    public int getLastDiceRoll(){ return Dice.lastRoll;}

    public int throwDice() {
        return Dice.rollDice();
    }

    public void decreaseWall() {
        player.decreaseWall();
    }

    public int getTrebutchet() {
        return enemy.getTrebutchet();
    }
    
    
    private static class Dice {
        private static int lastRoll;
        private static int rollDice(){
            lastRoll = (int) ((Math.random()*6)+1);
            return lastRoll;
        }
        public static int getLastRoll(){
            return lastRoll;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        aux.append(player);
        aux.append("\n");
        aux.append(enemy);
        return aux.toString();
    }   

    
}