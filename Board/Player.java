package Board;

import Model.MyException;
import java.io.Serializable;

public class Player implements Serializable{
    private final Player_Track supplies;
    private final Player_Track morale;
    private final Player_Track wall;
    private final Tunnel_Track tunnel;
    private int raided_supplies;
    private int actions;
    
    public Player(){
        supplies = new Player_Track(new Supply());
        morale = new Player_Track(new Morale());
        wall = new Player_Track(new Wall());
        tunnel = new Tunnel_Track(new Soldier());
        this.raided_supplies = this.actions= 0;
    }
    
    public int getSupplies() throws MyException {
        return supplies.getPiecePositionNumber();
    }

    public int getActions(){
        return actions;
    }
    public void setActions(int a){
        actions = a;
    }

    public int getMorale() throws MyException {
        return morale.getPiecePositionNumber();
    }

    public int getWall() throws MyException {
        return wall.getPiecePositionNumber();
    }

    public int getRaided_supplies() {
        return raided_supplies;
    }

    public void addRaided_supplies(int raided_supplies) {
        if(raided_supplies == 2){
            this.raided_supplies = raided_supplies;
        }else if(this.raided_supplies + raided_supplies > 2){
                this.raided_supplies = 2;
        }else{
            this.raided_supplies += raided_supplies;
        }
    }
    public void raiseAction(){
        actions++;
    }
    public void raiseWall() { 
        wall.raise();
    }
    public void raiseSuppies(){
        supplies.raise();
    }
    public void raiseMorale(){
        morale.raise();
    }
    public void decreaseWall(){
        wall.decrease();
    }
    public void decreaseSupplies(){
        supplies.decrease();
    }
    public void decreaseMorale(){
        morale.decrease();
    }
    public boolean canDecreaseSupplies() {
        try {
            if(supplies.getPiecePositionNumber() == 0)
                return false;
        } catch (MyException ex) {}
        return true;
    }
    public boolean isWallStartingSpace() {
        return wall.onStartingPosition();
    }
    public boolean isMoraleStartingSpace() {
        return morale.onStartingPosition();
    }
    public boolean checkLoss() {
        int aux=0;
        try {
            if(getSupplies() == 0){
                ++aux;
            }
        } catch (MyException ex) {}
        try {
            if(getMorale() == 0){
                ++aux;
            }
        } catch (MyException ex) {}
        try {
            if(getWall() == 0){
                ++aux;
            }
        } catch (MyException ex) {}
        return (aux > 1);
    }
    public boolean playerOnEnemyLine(){
        return tunnel.onEnemyLine();
    }
    public void decreasePlayerActions(){
        actions--;
    }
    public void doEnemyCheckLine() {
        if(tunnel.onEnemyLine()){
            int dice = (int) (Math.random()*6 +1);
            if(dice==1){
                tunnel.soldiersDiedOnEnemyLines();
                raided_supplies = 0;
                morale.decrease();
            }
        }
    }
    public void soldierCaptured() {
        tunnel.soldiersDiedOnEnemyLines();
        raided_supplies = 0;
        morale.decrease();
    }
    public boolean playerStillHasActionsLeft() {
        return actions>0;
    }
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        aux.append(wall);
        aux.append(morale);
        aux.append(supplies);
        aux.append(tunnel);
        aux.append("Number of Player Actions: ").append(actions).append("\n");
        return aux.toString();
    }

    public boolean canUseTunnelMovement() {
        return (tunnel.onStartingPosition() || tunnel.onEnemyLine()) == false;
    }

    public boolean playerOnCastleSpace() {
        return tunnel.onStartingPosition();
    }

    public boolean automaticTunnelMovement() {
        if(tunnel.automaticMovement()){
            if(tunnel.onStartingPosition()){
                for(int i=0;i<raided_supplies;i++){
                    supplies.raise();
                }
                raided_supplies = 0;
            }
        return true;
        }
        return false;
    }

    public boolean fastTunnelMovement() {
        if(tunnel.fastTunnelMovement()){
            decreasePlayerActions();
            if(tunnel.onStartingPosition()){
                for(int i=0;i<raided_supplies;i++){
                    supplies.raise();
                }
                raided_supplies = 0;
            }
            return true;
        }
        return false;
    }

    public boolean getInsideTunnelMovement() {
        if(tunnel.getInsideTunnelMovement()){
            decreasePlayerActions();
            return true;
        }
        return false;
    }

    public boolean canDecreaseMorale() {
        try {
            if(morale.getPiecePositionNumber() == 0)
                return false;
        } catch (MyException ex) {}
        return true;
    }

    public void buyAction(int opt) {
        switch(opt){
            case 1:
                decreaseSupplies();
                raiseAction();
                break;
            case 2:
                decreaseMorale();
                raiseAction();
                break;
        }
    }
}
