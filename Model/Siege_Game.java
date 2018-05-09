package Model;

import Model.Constants.Enemy_Attack;
import State_Machine.*;
import UI.text.User_Interface_Text;
import java.io.Serializable;
import java.util.Observable;

public class Siege_Game extends Observable implements Constants, Serializable{
    private Game game;
    private States state;
    private User_Interface_Text user_interface;

    public Siege_Game(User_Interface_Text ui){
        this.game = new Game();
        user_interface=ui;
        this.addObserver(user_interface);
        setState(new Initial_State(game));
    }
    public void setGame(Game game) {
        this.game = game;
    }
    private void setState(States state) {
        this.state = state;
    }
    public Game getGame() {
        return game;
    }
    public States getState() {
        return state;
    }
    public boolean isLadder(int pos) throws MyException{
        return game.getEnemy().getLadderNumberPosition()==pos;
    }
    public boolean isBatteringRam(int pos) throws MyException{
        return game.getEnemy().getBatteringRamNumberPosition()==pos;
    }
    public boolean isSiegeTower(int pos) throws MyException{
        return game.getEnemy().getSiegeTowerNumberPosition()==pos;
    }
    public boolean can_archers() {
        try {
            if(!isLadder(TAM_TRACKS_ENEMY-1))
                return true;
        } catch (MyException ex) {}
        try {
            if(!isBatteringRam(TAM_TRACKS_ENEMY-1))
                return true;
        } catch (MyException ex) {}
        try {
            if(!isSiegeTower(TAM_TRACKS_ENEMY-1))
                return true;
        } catch (MyException ex) {}
        return false;
    }
    public void stateArchers(){
        setState(state.archers());
    }
    public void archers(Enemy_Attack ea){
        if(can_archers()){
            setState(state.Apply_Action_Rules(ea));
            setChanged();
            notifyObservers();
        }
    }
    public boolean can_boilling() {
        try {
            if(isLadder(N_ENEMY_CIRCLES))
                return true;
        } catch (MyException ex) {}
        try {
            if(isBatteringRam(N_ENEMY_CIRCLES))
                return true;
        } catch (MyException ex) {}
        try {
            if(isSiegeTower(N_ENEMY_CIRCLES))
                return true;
        } catch (MyException ex) {}
        return false;
    }
    public void stateBoilling() {
        setState(state.boiling());
    }
    public void boilling(Enemy_Attack ea) {
        if(can_boilling()){
            setState(state.Apply_Action_Rules(ea));
            setChanged();
            notifyObservers();
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
    public boolean canCoupure() {
        return !game.getPlayer().isWallStartingSpace();
    }
    public void coupure() {
        if(canCoupure()){
            setState(state.coupure());
            setChanged();
            notifyObservers();
        }
    }
    public boolean canRally() {
        return !game.getPlayer().isMoraleStartingSpace();
    }
    public void stateRally() {
        if(canRally())
            setState(state.Rally_Troops());
    }
    public void rally(boolean check) {
        setState(state.Apply_Rally_Rules(check));
        setChanged();
        notifyObservers();
    }
    public boolean canSupply(){ 
        return (game.getPlayer().playerOnEnemyLine());
    }
    public void supply() { //TODO
        if(canSupply()){
            setState(state.supply());
            setChanged();
            notifyObservers();
        }
    }
    public boolean canSabotage(){ 
        return (game.getPlayer().playerOnEnemyLine());
    }
    public void sabotage() {
        if(canSabotage()){
            setState(state.sabotage());
            setChanged();
            notifyObservers();
        }
    }
    public void setup() {
        setState(state.New_Game());
    }
    public void drawCard(){
        try {
            setState(state.Draw_Card());
        } catch (MyException ex) {
            setState(new Only_Raid_and_Sab_State(getGame()) );
        }
    }
    public void setActions(int na){
        setState(state.setActions(na));
    }
    public void removeSiegeFromGame() {
        game.removeSiegeFromGame();
    }
    public void returnWaitAction(){
        setState(state.returnWaitAction());
    }
    public void checkLossAnd2Enemy() {
        setState(state.checkLossAnd2Enemy());
    }
    public String drawBoards() {
        return game.drawBoards();
    }
    public String drawCardDay() {
        return game.drawCardDay();
    }
    public void endTurn() { //TODO
       setState(state.endTurn());
    }
    public String getText() {
        return game.getTextToOutput();
    }
    public boolean playerStillHasActionsLeft(){
        return game.playerStillHasActionsLeft();
    }
    @Override
    public String toString() {
        return game.toString();
    }

    public boolean canUseTunnelMovement() {
        return game.canUseTunnelMovement();
    }

    public boolean onEnemyLine() {
        return game.getPlayer().playerOnEnemyLine();
    }

    public void stateTunnel() {
        setState(state.Tunnel());
            
    }

    public boolean onCastleSpace() {
        return game.getPlayer().playerOnCastleSpace();
    }

    public void tunnelAuto() {
       if(canUseTunnelMovement()){
           setState(state.automaticTunnelMovement());
       }
    }

    public void tunnelFast() {
        if(canUseTunnelMovement()){
            setState(state.fastTunnelMovement());
        }
    }

    public void tunnelGetInside() {
        if(onCastleSpace()|| onEnemyLine())
            setState(state.getInsideTunnelMovement());
    }

    public boolean isLadderOnCloseCombat() {
        return game.getEnemy().isLadderOnCloseCombat();
    }
    public boolean isBatteringRamOnCloseCombat(){
        return game.getEnemy().isBatteringRamOnCloseCombat();
    }
    public boolean isSiegeTowerOnCloseCombat(){
        return game.getEnemy().isSiegeTowerOnCloseCombat();
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

    public boolean canBuyAction() {
        return game.getCanUseSupplyOrMorale();
    }

    public void stateBuyAction() {
        if(game.getCanUseSupplyOrMorale())
            setState(state.BuyAction());
    }
    public void buyAction(int opt) {
        switch(opt){
            case 1:
                if(canDecreaseSupply())
                    setState(state.BuyAction(opt));
                break;
            case 2:
                if(canDecreaseSupply())
                    setState(state.BuyAction(opt));
        }
        
    }

    public boolean canDecreaseSupply() {
        return game.getPlayer().canDecreaseSupplies();
    }

    public boolean canDecreaseMorale() {
        return game.getPlayer().canDecreaseMorale();
    }

 
}
