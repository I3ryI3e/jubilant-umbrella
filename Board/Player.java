package Board;

import Model.MyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {
    private final Player_Track supplies;
    private final Player_Track morale;
    private final Player_Track wall;
    private int tunnel;
    private int raided_supplies;
    private int actions;
    
    public Player(){
        supplies = new Player_Track(new Supply());
        morale = new Player_Track(new Morale());
        wall = new Player_Track(new Wall());
        this.tunnel = this.raided_supplies = this.actions= 0;
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
    
    public int getTunnel() {
        return tunnel;
    }

    public void setTunnel(int tunnel) {
        if(tunnel >= 0 && tunnel <4)
            this.tunnel = tunnel;
    }

    public int getRaided_supplies() {
        return raided_supplies;
    }

    public void setRaided_supplies(int raided_supplies) {
        if(raided_supplies >= 0 && raided_supplies < 3)
            this.raided_supplies = raided_supplies;
        else if(raided_supplies > 2)
            this.raided_supplies = 2;
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

    public boolean isWallStartingSpace() throws MyException {
        return wall.getPiecePositionNumber()== wall.getTrackSize()-1;
    }
    public boolean isMoraleStartingSpace() throws MyException{
        return morale.getPiecePositionNumber() == morale.getTrackSize()-1;
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
    
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        aux.append(wall);
        aux.append(morale);
        aux.append(supplies);
        aux.append("Number of Player Actions: ").append(actions).append("\n");
        return aux.toString();
    }    
}
