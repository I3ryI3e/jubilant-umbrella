package Model;

import Model.Constants.Enemy_Attack;
import State_Machine.*;
import java.io.Serializable;
import java.util.Observable;

public class Siege_Game extends Observable implements Constants, Serializable{
    private Game game;
    private States state;

    public Siege_Game(){
        this.game = new Game();
        setState(new Initial_State(game));
    }
    public void setGame(Game game) {this.game = game;}
    private void setState(States state) {
        this.state = state;
        if(game.checkLoss())
            this.state = new Game_Over(game);
        else if(game.TwoEnemyLine())
            this.state = new Close_Combat(game);
    }
    public Game getGame() {return game;}
    public States getState() {return state;}
    public boolean ladderOnStartingPosition() {return game.ladderOnStartingPosition();}
    public boolean batteringRamOnStartingPosition() {return game.batteringRamOnStartingPosition();}
    public boolean siegeTowerOnStartingPosition() {return game.siegeTowerOnStartingPosition();}
    public boolean can_archers() {
        if(!ladderOnStartingPosition())
                return true;
        if(!batteringRamOnStartingPosition())
                return true;
        return !siegeTowerOnStartingPosition();
    }
    public void stateArchers(){
        if(game.playerStillHasActionsLeft() && can_archers())
            setState(state.archers());
    }
    public void archers(Enemy_Attack ea){
        if(canUseArchers(ea)){
            setState(state.Apply_Action_Rules(ea));
            setChanged();
            notifyObservers();
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
    public boolean can_boilling() {
        if(game.canUseBoiling()){
            if(isLadderOnCircleSpace())
                return true;
            if(isBatteringRamOnCircleSpace())
                return true;
            return isSiegeTowerOnCircleSpace();
        }
        return false;
    }
    public void stateBoilling() {
        if(game.canUseBoiling() && game.playerStillHasActionsLeft())
            setState(state.boiling());
    }
    public void boilling(Enemy_Attack ea) {
        if(enemyIsOnCircle(ea) && game.playerStillHasActionsLeft() && game.canUseBoiling()){
            setState(state.Apply_Action_Rules(ea));
            setChanged();
            notifyObservers();
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
        if(game.playerStillHasActionsLeft() && game.enemiesOnCloseCombatPosition())
            setState(state.closeCombat());
        
    }
    public boolean can_close_combat(){
        if(isLadderOnCloseCombat())
            return true;
        if(isBatteringRamOnCloseCombat())
            return true;
        return isSiegeTowerOnCloseCombat();
    }
    public void closeCombat(Enemy_Attack ea) {
        if(enemyIsOnCloseCombat(ea) && game.playerStillHasActionsLeft()){
            setState(state.Apply_Action_Rules(ea));
            setChanged();
            notifyObservers();
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
    public boolean canCoupure() {return !game.getPlayer().isWallStartingSpace();}
    public void coupure() {
        if(canCoupure() && game.playerStillHasActionsLeft()){
            setState(state.coupure());
            setChanged();
            notifyObservers();
        }
    }
    public boolean canRally() {return !game.getPlayer().isMoraleStartingSpace();}
    public void stateRally() {
        if(canRally() && game.playerStillHasActionsLeft())
            setState(state.rally_Troops());
    }
    public void rally(boolean check) {
        setState(state.Apply_Rally_Rules(check));
        setChanged();
        notifyObservers();
    }
    public boolean canSupply(){return (game.getPlayer().playerOnEnemyLine());}
    public void supply() {
        if(canSupply() && game.playerStillHasActionsLeft()){
            setState(state.supply());
            setChanged();
            notifyObservers();
        }
    }
    public boolean canSabotage(){return (game.getPlayer().playerOnEnemyLine() && game.existsTrebuchet());}
    public void sabotage() {
        if(canSabotage() && game.playerStillHasActionsLeft() && game.existsTrebuchet()){
            setState(state.sabotage());
            setChanged();
            notifyObservers();
        }
    }
    public void setup() {setState(state.New_Game());}
    public void drawCard(){
        try {
            setState(state.Draw_Card());
            setChanged();
            notifyObservers();
        } catch (MyException ex) {
            setState(new Only_Raid_and_Sab_State(getGame()) );
            setChanged();
            notifyObservers();
        }
    }
    public void setActions(int na){setState(state.setActions(na));}
    public void removeSiegeFromGame() {game.removeSiegeFromGame();}
    public void returnWaitAction(){setState(state.returnWaitAction());}
    public String drawBoards() {return game.toString();}
    public String drawCardDay() {return game.drawCardDay();}
    public void endTurn() {
       setState(state.endTurn());
       setChanged();
       notifyObservers();
    }
    public String getText() {return game.getTextToOutput();}
    public boolean playerStillHasActionsLeft(){return game.playerStillHasActionsLeft();}
    public boolean canUseTunnelMovement() {return game.canUseTunnelMovement();}
    public boolean onEnemyLine() {return game.getPlayer().playerOnEnemyLine();}
    public void stateTunnel() {
        if(game.playerStillHasActionsLeft())
            setState(state.tunnel());
    }
    public boolean onCastleSpace() {return game.getPlayer().playerOnCastleSpace();}
    public void tunnelFree() {
       if(canUseTunnelMovement() && game.playerStillHasActionsLeft() && canMakeFreeMove()){
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
        if(game.getCanUseSupplyOrMorale())
            setState(state.buyAction());
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
    @Override
    public String toString() {
        return game.toString();
    }
}
