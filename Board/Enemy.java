package Board;

import Model.Constants;
import Model.Constants.Enemy_Attack;
import Model.MyException;
import java.util.List;

public class Enemy implements Constants {
    private int trebutchet;
    private Enemy_Track ladder;
    private Enemy_Track battering_ram;
    private Enemy_Track siege_tower;

    public Enemy(){
        this.trebutchet = 3;
        ladder = new Enemy_Track(new Ladder());
        battering_ram = new Enemy_Track(new Ram());
        siege_tower= new Enemy_Track(new Siege());
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
                case LADDER:
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

    public int getLadderNumberPosition() throws MyException {
        return ladder.getPiecePositionNumber();
    }

    public int getBatteringRamNumberPosition() throws MyException {
        return battering_ram.getPiecePositionNumber();
    }

    public int getSiegeTowerNumberPosition() throws MyException {
        return siege_tower.getPiecePositionNumber();
    }
    
    public String enemyLocation(){
        StringBuilder aux = new StringBuilder();
        aux.append("Track positions:");
        try {
            aux.append(" Ladder -> ").append(getLadderNumberPosition());
        } catch (MyException e) {
            aux.append(" Ladder doesn't exist.");
        }
        try {
            aux.append(" Battering Ram -> ").append(getBatteringRamNumberPosition());
        } catch (MyException e) {
            aux.append(" Battering Ram doesn't exist.");
        }
        try {
            aux.append(" Siege Tower -> ").append(getLadderNumberPosition());
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

    public void enemyAttack(Enemy_Attack ea) {
        switch(ea){
            case LADDER:
                goForwardLadder();
                break;
            case BATTERING_RAM:
                goForwardBatteringRam();
                break;
            case SIEGE_TOWER:
                goForwardSiegeTower();
                break;
            case SWORD:
                swordAttack();
        }
    }
    
    private void swordAttack(){
        int lp, bp, sp;
        try {
            lp = getLadderNumberPosition();
        } catch (MyException e) {
            lp=0;
        }
        try {
            bp = getBatteringRamNumberPosition();
        } catch (MyException e) {
            sp=0;
        }
        try {
            sp = getSiegeTowerNumberPosition();
        } catch (MyException e) {
            sp=0;
        }
        
    }
    
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        aux.append(ladder);
        aux.append(battering_ram);
        aux.append(siege_tower);
        aux.append("Trebuchet =").append(trebutchet).append("\n");
        return aux.toString();
    }

    public Position getLadderPosition() throws MyException {
        return ladder.getPiecePosition(ladder.getPiecePositionNumber());
    }

    public int getLadderStrength() throws MyException {
        return ladder.getStrength();
    }

    public int getBatteringRamStrength() throws MyException {
        return battering_ram.getStrength();
    }

    public int getSiegeTowerStrength() throws MyException {
        return siege_tower.getStrength();
    }

    public Position getBatteringRamPosition() throws MyException {
        return battering_ram.getPiecePosition(ladder.getPiecePositionNumber());
    }

    public Position getSiegeTowerPosition() throws MyException {
        return siege_tower.getPiecePosition(siege_tower.getPiecePositionNumber());
    }
    
}
