package Board;

import Model.Constants;
import Model.Constants.Enemy_Attack;
import Model.MyException;
import java.util.List;

public class Enemy implements Constants {
    private int trebutchet;
    private Track ladder;
    private Track battering_ram;
    private Track siege_tower;

    public Enemy(){
        this.trebutchet = 3;
        ladder = new Track(new Ladder());
        battering_ram = new Track(new Ram());
        siege_tower= new Track(new Siege());
    }
    public int getTrebutchet() {
        return trebutchet;
    }

    public void setTrebutchet(int trebutchet) {
        if(trebutchet > 0 && trebutchet < 4)
            this.trebutchet = trebutchet;
    }
    public void makeAttack(List<Enemy_Attack> ea){
        for (Enemy_Attack enemy_Attack : ea) {
            switch(enemy_Attack){
                case LADDERS:
                    ladder.goForward();
                    break;
                case BATTERING_RAM:
                    battering_ram.goForward();
                    break;
                case SIEGE_TOWER:
                    siege_tower.goForward();
                    break;
                case SWORD: 
                    //TODO!!!!!!
                    break;
                default:
                    break;
            }
        }
    }

    public int getLadderPosition() throws MyException {
        return ladder.getPiecePosition();
    }

    public int getBatteringRamPosition() throws MyException {
        return battering_ram.getPiecePosition();
    }

    public int getSiegeTowerPosition() throws MyException {
        return siege_tower.getPiecePosition();
    }
    
    public String enemyLocation(){
        StringBuilder aux = new StringBuilder();
        aux.append("Track positions:");
        try {
            aux.append(" Ladder -> ").append(getLadderPosition());
        } catch (MyException e) {
            aux.append(" Ladder doesn't exist.");
        }
        try {
            aux.append(" Battering Ram -> ").append(getBatteringRamPosition());
        } catch (MyException e) {
            aux.append(" Battering Ram doesn't exist.");
        }
        try {
            aux.append(" Siege Tower -> ").append(getLadderPosition());
        } catch (MyException e) {
            aux.append(" Siege Tower doesn't exist.");
        }
        
        return aux.toString();
    }

    public void removeSiegeFromGame() {
        siege_tower.removeFromGame();
    }
    public void goForwardLadder(){
        ladder.goForward();
    }
    public void goForwardBatteringRam(){
        battering_ram.goForward();
    }
    public void goForwardSiegeTower(){
        siege_tower.goForward();
    }
    public void goBackwardLadder(){
        ladder.goBackward();
    }
    public void goBackwardBatteringRam(){
        battering_ram.goBackward();
    }
    public void goBackwardSiegeTower(){
        siege_tower.goBackward();
    }
}
