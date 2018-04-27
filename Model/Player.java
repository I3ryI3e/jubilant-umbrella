package Model;

public class Player {
    private int supplies;
    private int morale;
    private int wall;
    private int tunnel;
    private int raided_supplies;
    private int actions;
    
    public Player(){
        this.supplies = this.morale = this.wall = 4;
        this.tunnel = this.raided_supplies = 0;
    }
    
    public int getSupplies() {
        return supplies;
    }

    public int getActions(){
        return actions;
    }
    public void setActions(int a){
        actions = a;
    }
    public void setSupplies(int supplies) {
        if(supplies >= 0 && supplies < 5)
            this.supplies = supplies;
        else if(supplies < 0)
            this.supplies = 0;
        else if(supplies > 4)
            this.supplies = 4;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        if(morale >= 0 && morale < 5)
            this.morale = morale;
        else if(morale < 0)
            this.morale = 0;
        else if(morale > 4)
            this.morale = 4;
    }

    public int getWall() {
        return wall;
    }

    public void setWall(int wall) {
        if(wall >= 0 && wall < 5)
            this.wall = wall;
        else if(wall < 0)
            this.wall = 0;
        else if(wall > 4)
            this.wall = 4;
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
}
