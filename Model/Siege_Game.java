package Model;

import Model.Constants.Enemy_Attack;
import State_Machine.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Observable;

public class Siege_Game implements Constants, Serializable{
    private Game game;
    private States state;

    public Siege_Game(){
        this.game = new Game();
        setState(new Initial_State(game));
    }
    
    public void setGame(Game game) {this.game = game;}
    
    private void setState(States state) {this.state = state;}
    
    public States getState() {return state;}
    
    public String getEnemy() {return game.getEnemy().toString();}
    
    public String getPlayer() {return game.getPlayer().toString();}
    
    public int getActiveCardNumber() {return game.getActiveCardNumber();}    
    
    public boolean ladderOnStartingPosition() {return game.ladderOnStartingPosition();}
    
    public boolean batteringRamOnStartingPosition() {return game.batteringRamOnStartingPosition();}
    
    public boolean siegeTowerOnStartingPosition() {return game.siegeTowerOnStartingPosition();}
    
    public boolean canArchers() {
        if(!playerStillHasActionsLeft())
            return false;
        if(getSabAndRaidStateActive())
            return false;
        if(!ladderOnStartingPosition())
                return true;
        if(!batteringRamOnStartingPosition())
                return true;
        return !siegeTowerOnStartingPosition();
    }
    
    public void stateArchers(){
        if(canArchers()){
            setState(state.archers());
        }
    }
    
    public void archers(Enemy_Attack ea){
        if(canUseArchers(ea)){
            setState(state.Apply_Action_Rules(ea));
        }
    }
    
    private boolean canUseArchers(Enemy_Attack ea) {
        switch(ea){
            case LADDER:
                return !game.ladderOnStartingPosition();
            case BATTERING_RAM:
                return !game.batteringRamOnStartingPosition();
            case SIEGE_TOWER:
                return (!game.siegeTowerOnStartingPosition() && siegeTowerExists());
        }
        return false;
    }
    
    public boolean canBoiling() {
        if(game.canUseBoiling()){
            if(!playerStillHasActionsLeft())
                return false;
            if(getSabAndRaidStateActive())
                return false;
            if(isLadderOnCircleSpace())
                return true;
            if(isBatteringRamOnCircleSpace())
                return true;
            return isSiegeTowerOnCircleSpace();
        }
        return false;
    }
    
    public void stateBoilling() {
        if(canBoiling()){
            setState(state.boiling());
        }
        
    }
    
    public void boiling(Enemy_Attack ea) {
        if(enemyIsOnCircle(ea) && game.canUseBoiling()){
            setState(state.Apply_Action_Rules(ea));
        }
    }
    
    private boolean enemyIsOnCircle(Enemy_Attack ea) {
         switch(ea){
            case LADDER:
                return isLadderOnCircleSpace();
            case BATTERING_RAM:
                return isBatteringRamOnCircleSpace();
            case SIEGE_TOWER:
                return isSiegeTowerOnCircleSpace();
            default:
                return false;
        }
    }
    
    public void stateCloseCombat() {
        if(canCloseCombat()){
            setState(state.closeCombat());
        }
        
    }
    
    public boolean canCloseCombat(){
        if(!playerStillHasActionsLeft())
            return false;
        if(getSabAndRaidStateActive())
            return false;
        return game.enemiesOnCloseCombatPosition();
    }
    
    public void closeCombat(Enemy_Attack ea) {
        if(enemyIsOnCloseCombat(ea) && game.playerStillHasActionsLeft()){
            setState(state.Apply_Action_Rules(ea));
        }
    }
    
    private boolean enemyIsOnCloseCombat(Enemy_Attack ea) {
        switch(ea){
            case LADDER:
                return isLadderOnCloseCombat();
            case BATTERING_RAM:
                return isBatteringRamOnCloseCombat();
            case SIEGE_TOWER:
                return isSiegeTowerOnCloseCombat();
            default:
                return false;
        }
    }
    
    public boolean canCoupure() {
        if(!playerStillHasActionsLeft())
            return false;
        if(getSabAndRaidStateActive())
            return false;
        return !game.getPlayer().isWallStartingSpace();
    }
    
    public void coupure() {
        if(canCoupure()){
            setState(state.coupure());
        }
    }
    
    public boolean canRally() {
        if(!playerStillHasActionsLeft())
            return false;
        if(getSabAndRaidStateActive())
            return false;
        return !game.getPlayer().isMoraleStartingSpace();
    }
    
    public void stateRally() {
        if(canRally()){
            setState(state.rally_Troops());
        }
    }
    
    public void rallyPlus1DRM() {
        if(canDecreaseSupply()){
            setState(state.Apply_RallyPlus1DRM_Rules());
        }
    }
    
    public void normalRally() {
        setState(state.Apply_NormalRally_Rules());
    }
    
    public boolean canSupplyRaid(){
        if(!playerStillHasActionsLeft())
            return false;
        return (game.getPlayer().playerOnEnemyLine());
    }
    
    public void supplyRaid() {
        if(canSupplyRaid()){
            setState(state.supplyRaid());
        }
    }
    
    public boolean canSabotage(){
        if(!playerStillHasActionsLeft())
            return false;
        return (game.getPlayer().playerOnEnemyLine() && game.existsTrebuchet());
    }
    
    public void sabotage() {
        if(canSabotage() && game.existsTrebuchet()){
            setState(state.sabotage());
        }
    }
    
    public void setup() {
        setState(state.New_Game());
    }
    public void enemyCheckLine(){
        if(game.playerOnEnemyLine()){
            setState(state.enemyCheckLine());
        }
    }
    
    public void drawCard(){
        setState(state.Draw_Card());
    }
    
    public void removeSiegeFromGame() {game.removeSiegeFromGame();}
    
    public void returnWaitAction(){
        setState(state.returnWaitAction());
    }
    
    public String drawBoards() {return game.toString();}
    
    public String drawCardDay() {return game.drawCardDay();}
    
    public void endTurn() {
       setState(state.endTurn());
    }
    
    public String getText() {return game.getTextToOutput();}
    
    public boolean playerStillHasActionsLeft(){return game.playerStillHasActionsLeft();}
    
    public int numberOfActionsAvailable(){return game.numberOfActionsAvailable();}
    
    public boolean canUseTunnelMovement() {return game.canUseTunnelMovement();}
    
    public boolean onEnemyLine() {return game.getPlayer().playerOnEnemyLine();}
    
    public void stateTunnel() {
        if(game.playerStillHasActionsLeft() && (!getSabAndRaidStateActive())){
            setState(state.tunnel());
        }else if ((!game.playerStillHasActionsLeft()) && (!getSabAndRaidStateActive()) && game.getCanMakeFreeMove())
            setState(state.tunnel());
    }
    
    public boolean onCastleSpace() {return game.getPlayer().playerOnCastleSpace();}
    
    public void tunnelFree() {
       if(canUseTunnelMovement() && canMakeFreeMove()){
           setState(state.freeTunnelMovement());
       }
    }
    
    public void tunnelFast() {
        if(canUseTunnelMovement() && game.playerStillHasActionsLeft()){
            setState(state.fastTunnelMovement());
        }
    }
    
    public void tunnelGetInside() {
        if(onCastleSpace()|| onEnemyLine())
            setState(state.getInsideTunnelMovement());
    }
    
    public boolean isLadderOnCloseCombat() {return game.getEnemy().isLadderOnCloseCombat();}
    
    public boolean isBatteringRamOnCloseCombat(){return game.getEnemy().isBatteringRamOnCloseCombat();}
    
    public boolean isSiegeTowerOnCloseCombat(){return game.getEnemy().isSiegeTowerOnCloseCombat();}
    
    public boolean isLadderOnCircleSpace() {return game.getEnemy().isLadderOnCircleSpace();}
    
    public boolean isBatteringRamOnCircleSpace(){return game.getEnemy().isBatteringRamOnCircleSpace();}
    
    public boolean isSiegeTowerOnCircleSpace(){return game.getEnemy().isSiegeTowerOnCircleSpace();}
    
    public boolean canBuyAction() {return game.getCanUseSupplyOrMorale();}
    
    public boolean siegeTowerExists(){ return game.siegeTowerExists();}
    
    public void stateBuyAction() {
        if(game.getCanUseSupplyOrMorale()){
            setState(state.buyAction());
        }
    }
    
    public void buyAction(int opt) {
        switch(opt){
            case 1:
                if(canDecreaseSupply())
                    setState(state.buyAction(opt));
                break;
            case 2:
                if(canDecreaseSupply())
                    setState(state.buyAction(opt));
        }    
    }
    
    public boolean canDecreaseSupply() {return game.getPlayer().canDecreaseSupplies();}
    
    public boolean canDecreaseMorale() {return game.getPlayer().canDecreaseMorale();}
    
    public boolean canMakeFreeMove(){return game.getCanMakeFreeMove();}
    
    public boolean check2Enemy(){return game.TwoEnemyLine();}
    
    public void returnInitialState() {setState(state.returnInitialState());}
    
    public boolean getSabAndRaidStateActive() {return game.getSabAndRaidStateActive();}
    
    public Siege_Game loadGame(File file) throws ClassNotFoundException, IOException {
        return ((Siege_Game) FileUtility.retrieveGameFromFile(file));   
    }
    
    public boolean saveGame(File file) {
        try {
            FileUtility.saveGameToFile(file, this);
        } catch (IOException ex) {}
        return false;
    }
    
    @Override
    public String toString() {
        return game.toString();
    }

    public int getWeaponPosNum(String type) throws MyException {
        return game.getWeaponPosNum(type);
    }

    public int getGameDay() {
        return game.getGame_day();
    }

    int getPlayerLocation(String type) {
        return game.getPlayerLocation(type);
    }

    int getSoldierLocation() {
        return game.getSoldierLocation();
    }

    public boolean getSoldierGoing() {
        return game.getSoldierGoing();
    }

    public int getNumberOfCardsInDeck() {
        return game.getNumberOfCardsInDeck();
    }

    public int getNumberOfSupplies() {
        return game.getNumberOfSupplies();
    }

    public int getDiceResult() {
       return game.getLastDiceRoll();
    }

    public int getTrebutchetNumber() {
       return game.getTrebutchet();
    }

    public boolean diceWasRolled() {
        return game.diceWasRolled();
    }

    public int getNumberOfActions() {
        return game.getNumberOfActions();
    }

    public void resetDice() {
        game.resetDice();
    }

}
