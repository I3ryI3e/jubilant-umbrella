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
    public boolean can_archers() throws MyException{
        return !(isLadder(TAM_TRACKS_ENEMY-1) && isBatteringRam(TAM_TRACKS_ENEMY-1) && isSiegeTower(TAM_TRACKS_ENEMY-1));
    }
    public void stateArchers(){
        setState(state.archers());
    }
    public void archers(Enemy_Attack ea){
        setState(state.Apply_Action_Rules(ea));
        setChanged();
        notifyObservers();
    }
    public boolean can_boilling() throws MyException{
        return (isLadder(N_ENEMY_CIRCLES) || isBatteringRam(N_ENEMY_CIRCLES) || isSiegeTower(N_ENEMY_CIRCLES));
    }
    public void stateBoilling() {
        setState(state.boiling());
    }
    public void boilling(Enemy_Attack ea) {
        setState(state.Apply_Action_Rules(ea));
        setChanged();
        notifyObservers();
    }
    public boolean can_close_combat() throws MyException{
        return (isLadder(N_ENEMY_CLOSE_COMBAT) || isBatteringRam(N_ENEMY_CLOSE_COMBAT) || isSiegeTower(N_ENEMY_CLOSE_COMBAT));
    }
    public void closeCombat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean canCoupure() throws MyException{
        return !game.getPlayer().isWallStartingSpace();
    }
    public void coupure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean canRally() throws MyException{
        return !game.getPlayer().isMoraleStartingSpace();
    }
    public void rally() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean canSupply(){ 
        return (game.getPlayer().playerOnEnemyLine());
    }
    public void supply() { //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean canSabotage(){ 
        return (game.getPlayer().playerOnEnemyLine());
    }
    public void sabotage() { //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void setup() {
        setState(state.New_Game());
    }
    public void drawCard(){
        setState(state.Draw_Card());
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
    
    @Override
    public String toString() {
        return game.toString();
    }
}
