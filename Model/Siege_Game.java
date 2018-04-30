package Model;

import Model.Constants.Enemy_Attack;
import State_Machine.*;
import java.util.List;

public class Siege_Game implements Constants{
    private Game game;
    private States state;

    public Siege_Game(){
        this.game = new Game();
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
        return game.getEnemy().getLadderPosition()==pos;
    }
    
    public boolean isBatteringRam(int pos) throws MyException{
        return game.getEnemy().getBatteringRamPosition()==pos;
    }
    
    public boolean isSiegeTower(int pos) throws MyException{
        return game.getEnemy().getSiegeTowerPosition()==pos;
    }

    public boolean can_archers() throws MyException{
        return !(isLadder(4) && isBatteringRam(4) && isSiegeTower(4));
    }

    public boolean can_boilling() throws MyException{
        return (isLadder(1) || isBatteringRam(1) || isSiegeTower(1));
    }
    
    public void boilling(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean can_close_combat() throws MyException{
        return (isLadder(0) || isBatteringRam(0) || isSiegeTower(0));
    }
    
    public void closeCombat(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean canCoupure() throws MyException{
        return game.getPlayer().isWallStartingSpace();
    }

    public void coupure(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean canRally() throws MyException{
        return game.getPlayer().isMoraleStartingSpace();
    }
    
    public void rally(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean canSupply(){ //TODO
        return (game.getPlayer().getTunnel() == 3 && game.getPlayer().getRaided_supplies() != 2);
    }
    
    public void supply(int dice) { //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean canSabotage(){ //TODO
        return (game.getPlayer().getTunnel() == 3);
    }
    
    public void sabotage(int dice) { //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setup() {
        game.setup();
    }
    public void archers(int dice, Enemy_Attack enemy_mov){
        setState(state.archers(dice, enemy_mov));
    }
    public void setActions(int na){
        setState(state.setActions(na));
    }

    public void removeSiegeFromGame() {
        game.removeSiegeFromGame();
    }
}
