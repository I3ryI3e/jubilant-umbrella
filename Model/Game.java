package Model;

import Board.Close_Combat_Square;
import Board.Enemy;
import Board.Player;
import Card_Events.Event;
import Cards.*;
import Model.Constants.Enemy_Attack;
import UI.Graphics.ConstantsGUI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game implements Serializable, Constants, ConstantsGUI{
    private Player player;
    private Enemy enemy;
    private int gameDay;
    private List<Card> deck;
    private List<Card> discard;
    private StringBuffer textToOutput;
    private boolean canUseSupllyOrMoraleToOneMoreAction;
    private boolean canUseBoiling;
    private boolean canUseFreeMovement;
    private boolean sabAndRaidStateActive;

    public Game(){
        this.deck = new ArrayList<>();
        this.discard = new ArrayList<>();
        this.textToOutput = new StringBuffer();
    }
    
    public int getGame_day(){return gameDay;}
    public int getActiveCardNumber(){return discard.size()>0?discard.get(0).getCardNumber():0;}
    
    public boolean getCanUseSupplyOrMorale(){return canUseSupllyOrMoraleToOneMoreAction;}
    
    public void changeCanUseSupply(){this.canUseSupllyOrMoraleToOneMoreAction = !this.canUseSupllyOrMoraleToOneMoreAction;}
    
    public boolean canUseBoiling(){return canUseBoiling;}
    
    public void setSabAndRaidStateActive(boolean bool){
        this.sabAndRaidStateActive=bool;
    }
    public boolean getSabAndRaidStateActive(){
        return sabAndRaidStateActive;
    }
    
    public void changeUseBoiling(){this.canUseBoiling= !this.canUseBoiling;}
    
    public String getTextToOutput(){
//        String aux = textToOutput.toString();
//        textToOutput.delete(0, textToOutput.length());
//        return aux;
        return textToOutput.toString();
    }
    
    public void setGame_day(int game_day){this.gameDay = game_day;}
    
    public Player getPlayer() {return player;}
    
    public Enemy getEnemy() {return enemy;}
    
    public void setup() {
        this.player= new Player();
        this.enemy= new Enemy();
        this.gameDay = 0;
        deck.clear();
        discard.clear();
        deck.add(0,new Card1());
        deck.add(1,new Card2());
        deck.add(2,new Card3());
        deck.add(3,new Card4());
        deck.add(4,new Card5());
        deck.add(5,new Card6());
        deck.add(6,new Card7());
        Collections.shuffle(deck);
        this.canUseSupllyOrMoraleToOneMoreAction=true;
        this.canUseFreeMovement=true;
        this.canUseBoiling=true;
        this.sabAndRaidStateActive=false;
    }
    private Event getActiveEvent(){
        return discard.get(0).getDayX(gameDay).getEvent();
    }
    
    public void archers(Enemy_Attack ea) { 
        int dice = Dice.rollDice();
        int bonus = 0;
        Event activeEvent = getActiveEvent();
        textToOutput.append("\nDado: ").append(dice);
        switch(ea){                                  
            case LADDER:
            try {
                bonus= activeEvent.getLadderMod()+ activeEvent.getAllAttackMod() + enemy.getPositionModifier(ea,activeEvent);
            } catch (MyException ex) {
                bonus = activeEvent.getLadderMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice+bonus > enemy.getLadderStrength()){
                    enemy.goBackwardLadder();
                    textToOutput.append("\nVictory, Ladder is going to backout!\n");
                }else
                    textToOutput.append("\nYour archers are too inexperienced and missed! You lost the battle!\n");
            } catch (MyException ex) {}
            break;
            case BATTERING_RAM:
            try {
                bonus = activeEvent.getRamMod() + activeEvent.getAllAttackMod()  + enemy.getPositionModifier(ea,activeEvent);
            } catch (MyException ex) {
                bonus = activeEvent.getRamMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > enemy.getBatteringRamStrength()){
                    enemy.goBackwardBatteringRam();
                    textToOutput.append("\nVictory, Battering Ram is going to backout!");
                }else 
                    textToOutput.append("\nYour archers were drunk! You lost the battle!\n");
            } catch (MyException ex) {}
            break;
            case SIEGE_TOWER:
            try {
                bonus = activeEvent.getSiegeMod() + activeEvent.getAllAttackMod() + enemy.getPositionModifier(ea,activeEvent);
            } catch (MyException ex) {
                bonus = activeEvent.getSiegeMod();
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > enemy.getSiegeTowerStrength()){
                    enemy.goBackwardSiegeTower();
                    textToOutput.append("\nVictory, Siege Tower is going to backout!");
                }else
                    textToOutput.append("\nThe Tower is too strong! You lost the battle!\n");
            } catch (MyException ex) {}
            break;
        }
        player.decreasePlayerActions();
    }
    
    public void boiling(Enemy_Attack ea) {
        int dice = Dice.rollDice();
        int bonus = 0;
        Event activeEvent = getActiveEvent();
        textToOutput.append("\nDado: ").append(dice);
        switch(ea){                                  
            case LADDER:
            try {
                bonus = activeEvent.getLadderMod()+ activeEvent.getCircleAttackMod() + enemy.getPositionModifier(ea,activeEvent) +1;
            } catch (MyException ex) {
                bonus = activeEvent.getLadderMod() +1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus  > enemy.getLadderStrength()){
                    enemy.goBackwardLadder();
                    textToOutput.append("\nVictory, Ladder is going to backout!");
                }else
                    textToOutput.append("\nThe oil was not hot enough, you lost the battle!");
            } catch (MyException ex) {}
            break;
            case BATTERING_RAM:
            try {
                bonus = activeEvent.getRamMod() + activeEvent.getCircleAttackMod()  + enemy.getPositionModifier(ea,activeEvent)+1;
            } catch (MyException ex) {
                bonus = discard.get(0).getDayX(gameDay).getEvent().getRamMod()+1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus  > enemy.getBatteringRamStrength()){
                    enemy.goBackwardBatteringRam();
                    textToOutput.append("\nVictory, Battering Ram is going to backout!");
                }else
                    textToOutput.append("\nYou missed the target and lost the battle!");
            } catch (MyException ex) {}
            break;
            case SIEGE_TOWER:
            try {
                bonus = activeEvent.getSiegeMod() + activeEvent.getCircleAttackMod() + enemy.getPositionModifier(ea,activeEvent)+1;
            } catch (MyException ex) {
                bonus = activeEvent.getSiegeMod()+1;
            }
            textToOutput.append("\nBonus to Dice: ").append(bonus).append("\n");
            try {
                if(dice + bonus > enemy.getSiegeTowerStrength()){
                    enemy.goBackwardSiegeTower();
                    textToOutput.append("\nVictory, Ladder is going to backout!");
                }else
                    textToOutput.append("\nYou coulnd't break the Tower defenses and lost the battle!");
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
        Event activeEvent = getActiveEvent();
        int bonus =activeEvent.getAllAttackMod() + activeEvent.getCloseCombatMod();
        textToOutput.append("\nDado: ").append(dice).append("\nBonus to dice: ");
        switch(ea){
            case LADDER:
                try {
                    if(enemy.getLadderPosition() instanceof Close_Combat_Square){
                        if( dice+bonus > CLOSE_COMBAT_POSITION_POWER){
                            enemy.goBackwardLadder();
                            textToOutput.append(bonus).append("\nVictory, Ladder is going to backout!\n");
                            player.decreasePlayerActions();
                        }else{
                            textToOutput.append("\nThe enemies were too strong in close combat! You lost the battle!");
                        }
                    }
                } catch (MyException ex) {}
                break;
            case BATTERING_RAM:
                try{
                    if(enemy.getBatteringRamPosition() instanceof Close_Combat_Square){
                        if( dice+bonus > CLOSE_COMBAT_POSITION_POWER){
                            enemy.goBackwardBatteringRam();
                            textToOutput.append(bonus).append("\nVictory, Battering Ram is going to backout!\n");
                            player.decreasePlayerActions();
                        }else{
                            textToOutput.append("\nThe enemies were too strong in close combat! You lost the battle!");
                        }
                    }
                } catch (MyException ex) {} 
                break;
            case SIEGE_TOWER:
                try{
                    if(enemy.getSiegeTowerPosition() instanceof Close_Combat_Square){
                        if( dice+bonus > CLOSE_COMBAT_POSITION_POWER){
                            enemy.goBackwardSiegeTower();
                            textToOutput.append(bonus).append("\nVictory, Siege Tower is going to backout!\n");
                            player.decreasePlayerActions();
                        }else{
                            textToOutput.append("\nThe enemies were too strong in close combat! You lost the battle!");
                        }
                    }
                } catch (MyException ex) {}
                break;
        }
        player.decreasePlayerActions();
    }
    
    public void normalRally() {
        rally(0);
    }
    
    public void rallyPlus1DRM() {
        player.decreaseSupplies();
        rally(1);
    }
    
    private void rally(int DRM) {
        int dice = Dice.rollDice();
        int bonus = getActiveEvent().getMoraleMod() + DRM;
        textToOutput.append("\nDado: ").append(dice).append("\nBonus to Dice: ").append(bonus).append("\n");
        if(dice + bonus >= 5){
            player.raiseMorale();
            textToOutput.append("\nVictory, rally troops successfully done!");
        }else
            textToOutput.append("\nYou made a poor speech and your soldiers didn't care! You weren't able to raise morale!");
        player.decreasePlayerActions();
    }
    
    public void coupure(){
        int dice = Dice.rollDice();
        int bonus = getActiveEvent().getCoupureMod();
        textToOutput.append("\nDado: ").append(dice).append("\nBonus to Dice: ").append(bonus).append("\n");
        if(dice + bonus >= 5){
            player.raiseWall();
            textToOutput.append("\nVictory, coupure successfully done!");
        }else
            textToOutput.append("\nYour workers were tired for lack of sleep! You weren't able raise the wall!");
        player.decreasePlayerActions();
    }
    
    public void sabotage() {
        int dice = Dice.rollDice();
        int bonus = getActiveEvent().getSabotageMod();
        textToOutput.append("\nDado: ").append(dice).append("\nBonus to Dice: ").append(bonus).append("\n");
        if(dice + bonus >= 5){
            enemy.removeTrebutchet();
            textToOutput.append("\nVictory, sabotage successfully done!");
        }else if(dice == 1){
            player.soldierCaptured();
            textToOutput.append("\nYour soldier as been captured! You lost morale!");
        }else
            textToOutput.append("\nThe enemy watch was too tight and your soldiers weren't able to get near the trebuchets!");
        player.decreasePlayerActions();
    }
    
    public void supplyRaid() {
        int dice = Dice.rollDice();
        int bonus = getActiveEvent().getRaidMod();
        textToOutput.append("\nDado: ").append(dice).append("\nBonus to Dice: ").append(bonus).append("\n");
        if(dice + bonus == 6){
            player.addRaided_supplies(2);
            textToOutput.append("\nVictory, 2 supplies successfully done!");
        }else if(dice == 1){
            player.soldierCaptured();
            textToOutput.append("\nYour soldier as been captured! You lost morale!");
        }else if(!(dice + bonus == 2)){
            player.addRaided_supplies(1);
            textToOutput.append("\nVictory, 1 supply successfully done!");
        }else
            textToOutput.append("\nThe enemy watch was too tight and your soldiers weren't able to get near the supplies!");
        player.decreasePlayerActions();
    }
    
    public void removeSiegeFromGame() {enemy.removeSiegeFromGame();}
    
    public void drawAndResolveCard(){
        drawCard();
        resolveCard();
    }
    
    private void drawCard() {discard.add(0, deck.remove(0));}
    
    private void resolveCard(){
        discard.get(0).resolve(getGame_day(), this);
    }
    
    void setPlayerActions(int n_player_actions) {player.setActions(n_player_actions);}
    
    void enemyAttack(List<Enemy_Attack> enemy_attack) {
        for(int i=0;i<enemy_attack.size();i++){
            enemy.enemyAttack(enemy_attack.get(i), this);
        }
    }
    
    public boolean checkLoss() {return (player.checkLoss() || enemy.isNumEnemyInCloseCombat(3));}
    
    public boolean TwoEnemyLine() {return (enemy.isNumEnemyInCloseCombat(2));}
    
    public void DecreaseMoralEvent() {player.decreaseMorale();}
    
    public String drawBoards() {
        StringBuilder aux = new StringBuilder();
        aux.append(player).append("\n\n").append(enemy).append("\n\n");
        return aux.toString();
    }
    
    public String drawCardDay() {return discard.get(0).printDayX(gameDay, discard.size());}
    
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
        this.sabAndRaidStateActive=false;
    }
    
    private void reputAllCardsIntoDeck() {
        for (int i = 0; i < discard.size(); i++) {
            deck.add(i,discard.get(discard.size()-1-i));
        }
        discard.clear();
        Collections.shuffle(deck);
    }
    
    public void DecreaseSuppliesEvent() {player.decreaseSupplies();}
    
    public void addTrebuchetEvent() {enemy.increaseNumberOfTrebuchet();}

    public boolean playerStillHasActionsLeft() {return player.playerStillHasActionsLeft();}

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

    public void enemyCheckLine() {textToOutput.append(player.doEnemyCheckLine(Dice.rollDice()));}

    public boolean endTurnLoss() {return (player.victoryOrLoss() || enemy.victoryOrLoss());}

    public void endOfDayPhaseTunnel() {textToOutput.append(player.endOfDayPhaseTunnel());}
    
    public boolean siegeTowerExists() {return enemy.siegeTowerExists();}
    
    public boolean existsTrebuchet() {return enemy.getTrebutchet()>0;}

    public boolean isNumEnemyInCloseCombat(int num) {return enemy.isNumEnemyInCloseCombat(num);}
    
    public boolean playerOnEnemyLine() {return player.playerOnEnemyLine();}    
    
    public int getLastDiceRoll(){ return Dice.lastRoll;}

    public int throwDice() {return Dice.rollDice();}

    public void decreaseWall() {
        player.decreaseWall();
    }

    public int getTrebutchet() {
        return enemy.getTrebutchet();
    }

    public int getLadderPos() throws MyException {
        return enemy.getLadderNumberPosition();
    }

    public int getWeaponPosNum(String type) throws MyException {
        switch(type){
            case LADDER_ICON:
                return getEnemy().getLadderNumberPosition();
            case BATTERING_RAM_ICON:
                return getEnemy().getBatteringRamNumberPosition();
            case SIEGE_TOWER_ICON:
                return getEnemy().getSiegeTowerNumberPosition();
            default:
                throw new MyException();
        }
    }

    public int getPlayerLocation(String type) {
        switch(type){
            case MORALE_ICON:
        {
            try {
                return getPlayer().getMorale();
            } catch (MyException ex) {
                return 4;
            }
        }
            case WALL_ICON:
        {
            try {
                return getPlayer().getWall();
            } catch (MyException ex) {
                return 4;
            }
        }
            case SUPPLY_ICON:
        {
            try {
                return getPlayer().getSupplies();
            } catch (MyException ex) {
                return 4;
            }
        }
        }
        return 4;
    }

    public int getSoldierLocation() {
        return getPlayer().getSoldierLocation();
    }

    public boolean getSoldierGoing() {
       return getPlayer().getSoldierGoing();
    }

    public int getNumberOfCardsInDeck() {
        return deck.size();
    }

    public int getNumberOfSupplies() {
        return player.getRaided_supplies();
    }

    boolean diceWasRolled() {
        return Dice.getChanged();
    }

    public int getNumberOfActions() {
        return player.getActions();
    }

    
    
    private static class Dice {
        private static int lastRoll;
        private static boolean wasRolled=false;
        
        private static int rollDice(){
            lastRoll = (int) ((Math.random()*6)+1);
            wasRolled=true;
            return lastRoll;
        }
        public static boolean getChanged(){
            boolean aux = wasRolled;
            wasRolled=false;
            return aux;
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