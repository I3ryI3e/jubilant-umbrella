package Model;

import State_Machine.*;

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
    
    public boolean is_ladder(int pos){
        return (game.getEnemy().getLadder() == pos);
    }
    
    public boolean is_battering_ram(int pos){
        return (game.getEnemy().getBattering_ram() == pos);
    }
    
    public boolean is_siege_tower(int pos){
        return (game.getEnemy().getSiege_tower() == pos);
    }

    public boolean can_archers(){
        return !(is_ladder(4) && is_battering_ram(4) && is_siege_tower(4));
    }

    public boolean can_boilling(){
        return (is_ladder(1) || is_battering_ram(1) || is_siege_tower(1));
    }
    
    public void boilling(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean can_close_combat(){
        return (is_ladder(0) || is_battering_ram(0) || is_siege_tower(0));
    }
    
    public void close_combat(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean can_coupure(){
        return (game.getPlayer().getWall() != 4);
    }

    public void coupure(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean can_rally(){
        return (game.getPlayer().getMorale() != 4);
    }
    
    public void rally(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean can_supply(){
        return (game.getPlayer().getTunnel() == 3 && game.getPlayer().getRaided_supplies() != 2);
    }
    
    public void supply(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean can_sabotage(){
        return (game.getPlayer().getTunnel() == 3);
    }
    
    public void sabotage(int dice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setup() {
        game.setup();
    }
    public void archers(int dice, Enemy_Attack enemy_mov){
        setState(state.archers(dice, enemy_mov));
    }
}
