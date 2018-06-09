
package Model;

import State_Machine.States;
import java.io.File;
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

    public void supply() {
        game.supply();
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

    public void quit() {
        game.quit();
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
    
    

    public boolean loadGame(File file) {
        return game.loadGame(file);
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
        return game.canSupply();
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
        this.game=load_game;
        setChanged();
        notifyObservers();
    }

    
     
    
}
