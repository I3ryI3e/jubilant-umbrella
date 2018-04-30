package Board;

import Model.MyException;

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
        return supplies.getPiecePosition();
    }

    public int getActions(){
        return actions;
    }
    public void setActions(int a){
        actions = a;
    }

    public int getMorale() throws MyException {
        return morale.getPiecePosition();
    }

    public int getWall() throws MyException {
        return wall.getPiecePosition();
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

    public void goForwardWall() { //TODO
        wall.goForward();
    }
    public void goForwardSuppies(){
        supplies.goForward();
    }
    public void goForwardMorale(){
        morale.goForward();
    }
    public void goBackwardWall(){
        wall.goBackward();
    }
    public void goBackwardSupplies(){
        supplies.goBackward();
    }
    public void goBackwardMorale(){
        morale.goBackward();
    }

    public boolean isWallStartingSpace() throws MyException {
        return wall.getPiecePosition()== wall.getTrackSize()-1;
    }
    public boolean isMoraleStartingSpace() throws MyException{
        return morale.getPiecePosition() == morale.getTrackSize()-1;
    }
}
