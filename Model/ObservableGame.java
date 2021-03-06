
package Model;

import State_Machine.States;
import java.io.File;
import java.io.IOException;
import java.util.Observable;


public class ObservableGame extends Observable {
    Siege_Game game;

    public ObservableGame(Siege_Game game) {
        this.game = game;
    }

    public void stateArchers() {
        game.stateArchers();
        setChanged();
        notifyObservers();
    }

    public void archers(Constants.Enemy_Attack ea) {
        game.archers(ea);
        setChanged();
        notifyObservers();
    }

    public void stateBoilling() {
        game.stateBoilling();
        setChanged();
        notifyObservers();
    }

    public void boiling(Constants.Enemy_Attack ea) {
        game.boiling(ea);
        setChanged();
        notifyObservers();
    }

    public void stateCloseCombat() {
        game.stateCloseCombat();
        setChanged();
        notifyObservers();
    }

    public void closeCombat(Constants.Enemy_Attack ea) {
        game.closeCombat(ea);
        setChanged();
        notifyObservers();
    }

    public void coupure() {
        game.coupure();
        setChanged();
        notifyObservers();
    }

    public void stateRally() {
        game.stateRally();
        setChanged();
        notifyObservers();
    }

    public void rallyPlus1DRM() {
        game.rallyPlus1DRM();
        setChanged();
        notifyObservers();
    }

    public void normalRally() {
        game.normalRally();
        setChanged();
        notifyObservers();
    }

    public void supplyRaid() {
        game.supplyRaid();
        setChanged();
        notifyObservers();
    }

    public void sabotage() {
        game.sabotage();
        setChanged();
        notifyObservers();
    }

    public void setup() {
        game.setup();
        setChanged();
        notifyObservers();
    }

    public void drawCard() {
        game.enemyCheckLine();
        setChanged();
        notifyObservers();
        
        game.drawCard();
        setChanged();
        notifyObservers();
    }

    public void endTurn() {
        game.endTurn();
        setChanged();
        notifyObservers();
    }

    public void stateTunnel() {
        game.stateTunnel();
        setChanged();
        notifyObservers();
    }

    public void tunnelFree() {
        game.tunnelFree();
        setChanged();
        notifyObservers();
    }

    public void tunnelFast() {
        game.tunnelFast();
        setChanged();
        notifyObservers();
    }

    public void tunnelGetInside() {
        game.tunnelGetInside();
        setChanged();
        notifyObservers();
    }

    public void stateBuyAction() {
        game.stateBuyAction();
        setChanged();
        notifyObservers();
    }

    public void buyAction(int opt) {
        game.buyAction(opt);
        setChanged();
        notifyObservers();
    }

    public void returnInitialState() {
        game.returnInitialState();
        setChanged();
        notifyObservers();
    }

    public States getState() {
        return game.getState();
    }

    public boolean canArchers() {
        return game.canArchers();
    }

    public boolean canBoiling() {
        return game.canBoiling();
    }
    
    

    public void loadGame(File file) {
        try {
            setGame(game.loadGame(file));
        } catch (ClassNotFoundException | IOException ex) {}
    }

    public boolean saveGame(File file) {
        return game.saveGame(file);
    }

    public boolean canCloseCombat() {
        return game.canCloseCombat();
    }

    public boolean canCoupure() {
        return game.canCoupure();
    }

    public boolean canRally() {
        return game.canRally();
    }

    public boolean playerStillHasActionsLeft() {
        return game.playerStillHasActionsLeft();
    }

    public boolean canSabotage() {
        return game.canSabotage();
    }

    public boolean canSupply() {
        return game.canSupplyRaid();
    }

    public int getActiveCardNumber() {
        return game.getActiveCardNumber();
    }

    public void returnWaitAction() {
        game.returnWaitAction();
        setChanged();
        notifyObservers();
    }

    public boolean batteringRamOnStartingPosition() {
        return game.batteringRamOnStartingPosition();
    }

    public boolean ladderOnStartingPosition() {
        return game.ladderOnStartingPosition();
    }

    public boolean siegeTowerExists() {
        return game.siegeTowerExists();
    }

    public boolean siegeTowerOnStartingPosition() {
        return game.siegeTowerOnStartingPosition();
    }

    public boolean isLadderOnCircleSpace() {
        return game.isLadderOnCircleSpace();
    }

    public boolean isBatteringRamOnCircleSpace() {
        return game.isBatteringRamOnCircleSpace();
    }

    public boolean isSiegeTowerOnCircleSpace() {
        return game.isSiegeTowerOnCircleSpace();
    }

    public boolean isLadderOnCloseCombat() {
        return game.isLadderOnCloseCombat();
    }

    public boolean isBatteringRamOnCloseCombat() {
        return game.isBatteringRamOnCloseCombat();
    }

    public boolean isSiegeTowerOnCloseCombat() {
        return game.isSiegeTowerOnCloseCombat();
    }

    public String drawBoards() {
        return game.drawBoards();
    }

    public String drawCardDay() {
        return game.drawCardDay();
    }

    public boolean getSabAndRaidStateActive() {
        return game.getSabAndRaidStateActive();
    }

    public boolean canBuyAction() {
        return game.canBuyAction();
    }

    public String getEnemy() {
        return game.getEnemy();
    }

    public String getPlayer() {
        return game.getPlayer();
    }

    public boolean canDecreaseSupply() {
       return game.canDecreaseSupply();
    }

    public boolean canUseTunnelMovement() {
        return game.canUseTunnelMovement();
    }

    public boolean canMakeFreeMove() {
        return game.canMakeFreeMove();
    }

    public boolean onEnemyLine() {
        return game.onEnemyLine();
    }

    public boolean onCastleSpace() {
        return game.onCastleSpace();
    }

    public int numberOfActionsAvailable() {
        return game.numberOfActionsAvailable();
    }

    public boolean check2Enemy() {
       return game.check2Enemy();
    }

    public boolean canDecreaseMorale() {
        return game.canDecreaseMorale();
    }

    public String getText() {
        return game.getText();
    }

    public void setGame(Siege_Game load_game) {
        if( load_game != null){
            this.game=load_game;
            game.resetDice();
            setChanged();
            notifyObservers();
        }
    }


    public int getWeaponPosNum(String type) throws MyException {
        return game.getWeaponPosNum(type);
    }

    public int getGameDay() {
        return game.getGameDay();
    }

    public int getPlayerLocation(String type) {
        return game.getPlayerLocation(type);
    }

    public int getSoldierLocation() {
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
        return game.getDiceResult();
    }

    public int getTrebutchetNumber() {
        return game.getTrebutchetNumber();
    }

    public boolean diceWasRolled() {
        return game.diceWasRolled();
    }

    public int getNumberOfActions() {
       return game.getNumberOfActions();
    }

    
     
    
}
