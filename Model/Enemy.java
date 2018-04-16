package Model;

public class Enemy {
    private int trebutchet;
    private int ladder;
    private int battering_ram;
    private int siege_tower;

    public Enemy(){
        this.trebutchet = 3;
        this.battering_ram = this.ladder = this.siege_tower = 4;
    }
    public int getTrebutchet() {
        return trebutchet;
    }

    public void setTrebutchet(int trebutchet) {
        if(trebutchet > 0 && trebutchet < 4)
            this.trebutchet = trebutchet;
    }

    public int getLadder() {
        return ladder;
    }

    public void setLadder(int ladder) {
        if(ladder >= 0 && ladder < 5)
            this.ladder = ladder;
    }

    public int getBattering_ram() {
        return battering_ram;
    }

    public void setBattering_ram(int battering_ram) {
        if(battering_ram >= 0 && battering_ram < 5)
            this.battering_ram = battering_ram;
    }

    public int getSiege_tower() {
        return siege_tower;
    }

    public void setSiege_tower(int siege_tower) {
        if(siege_tower >= 0 && siege_tower < 5)
            this.siege_tower = siege_tower;
    }
    
    public String enemy_location(){
        return ("Track positions: Ladder -> " + getLadder() + "  Baterring Ram -> " + getBattering_ram() + "Siege Tower -> " + getSiege_tower());
    }
}
