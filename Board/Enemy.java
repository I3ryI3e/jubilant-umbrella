package Board;

import Model.Constants;
import Model.Constants.Enemy_Attack;
import Model.MyException;
import java.io.Serializable;
import java.util.List;

public class Enemy implements Constants, Serializable{
    private int trebutchet;
    private Enemy_Track ladder;
    private Enemy_Track battering_ram;
    private Enemy_Track siege_tower;

    public Enemy(){
        this.trebutchet = 3;
        ladder = new Enemy_Track(new Ladder());
        battering_ram = new Enemy_Track(new Battering_Ram());
        siege_tower= new Enemy_Track(new Siege_Tower());
    }
    public int getTrebutchet() {
        return trebutchet;
    }
    
    public void increaseNumberOfTrebuchet() {
        if(this.trebutchet<3)
            this.trebutchet++;
    }

    public void removeTrebutchet() {
        if(trebutchet > 0)
            --trebutchet;
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
        int lp, bp, sp, aux;
        try {
            lp = getLadderNumberPosition();
        } catch (MyException e) {
            lp=0;
        }
        try {
            bp = getBatteringRamNumberPosition();
        } catch (MyException e) {
            bp=0;
        }
        try {
            sp = getSiegeTowerNumberPosition();
        } catch (MyException e) {
            sp=0;
        }
        if(lp >= bp && lp >= sp){
            aux = lp;
        }else if(lp > bp && lp < sp){
            aux = sp;
        }else if(bp > sp){
            aux = bp;
        }else{
            aux = sp;
        }
        if(lp == aux)
            goForwardLadder();
        if(bp == aux)
            goForwardBatteringRam();
        if(sp == aux)
            goForwardSiegeTower();
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

    public boolean isNumEnemyInCloseCombat(int num) {
        int aux=0;
        try {
            if(getLadderNumberPosition() == 0){
                ++aux;
            }
        } catch (MyException ex) {}
        try {
            if(getBatteringRamNumberPosition() == 0){
                ++aux;
            }
        } catch (MyException ex) {}
        try {
            if(getSiegeTowerNumberPosition() == 0){
                ++aux;
            }
        } catch (MyException ex) {}
        return (aux == num);
    }
    
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        aux.append(ladder);
        aux.append(battering_ram);
        aux.append(siege_tower);
        aux.append("Trebuchet = ").append(trebutchet).append("\n");
        return aux.toString();
    }

    public boolean anyEnemyOnCloseCombat() {
        return (isNumEnemyInCloseCombat(1) || isNumEnemyInCloseCombat(2));
    }

    public boolean isLadderOnCloseCombat() {
        return ladder.onCloseCombat();
    }
    public boolean isBatteringRamOnCloseCombat(){
        return battering_ram.onCloseCombat();
    }
    public boolean isSiegeTowerOnCloseCombat(){
        return siege_tower.onCloseCombat();
    }

    public boolean isLadderOnCircleSpace() {
        return ladder.onCircleSpace();
    }
    public boolean isBatteringRamOnCircleSpace(){
        return battering_ram.onCircleSpace();
    }
    public boolean isSiegeTowerOnCircleSpace(){
        return siege_tower.onCircleSpace();
    }

    public boolean ladderOnStartingPosition() {
        return ladder.onStartingPosition();
    }
    public boolean batteringRamOnStartingPosition(){
        return battering_ram.onStartingPosition();
    }
    public boolean siegeTowerOnStartingPosition(){
        return siege_tower.onStartingPosition();
    }
}
