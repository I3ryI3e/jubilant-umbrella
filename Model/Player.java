package Model;

public class Player {
    private int supply;
    private int morale;
    private int wall;
    private int tunnel;
    private int raided_supplies;
    
    public Player(){
        this.supply = this.morale = this.wall = 4;
        this.tunnel = this.raided_supplies = 0;
        
    }
    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        if(supply >= 0 && supply < 5)
            this.supply = supply;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        if(morale >= 0 && morale < 5)
            this.morale = morale;
    }

    public int getWall() {
        return wall;
    }

    public void setWall(int wall) {
        if(wall >= 0 && wall < 5)
            this.wall = wall;
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
    }
    
    
    
}
