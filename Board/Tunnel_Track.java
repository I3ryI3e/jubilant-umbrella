
package Board;

import Model.MyException;
import java.util.ArrayList;

public class Tunnel_Track extends Track{
    private boolean going;
    public Tunnel_Track(Piece p){
        track = new ArrayList<>(N_TUNNEL_SPACES+2);
        track.add(new Castle_Position(p));
        for(int i=0;i < N_TUNNEL_SPACES;i++){
            track.add(new Square());
        }
        track.add(new Enemy_Line_Position());
        this.going=true;
    }

    @Override
    public boolean onStartingPosition() {
        try {
            return getPiecePosition(getPiecePositionNumber()) instanceof Castle_Position;
        } catch (MyException ex) {
            return false;
        }
    }
    public boolean onEnemyLine(){
        try {
            return getPiecePosition(getPiecePositionNumber()) instanceof Enemy_Line_Position;
        } catch (MyException ex) {
            return false;
        }
    }

    public void soldiersDiedOnEnemyLines() {
        track.get(0).setPiece(track.get(N_ENEMY_SQUARES-1).removePiece());
        going=true;
    }

    public boolean automaticMovement() {
        int pos;
        try {
            pos = getPiecePositionNumber();
        } catch (MyException ex) {
            return false;
        }
        if(!onStartingPosition()&&!onEnemyLine()){
            if(going){
                track.get(pos+1).setPiece(track.get(pos).removePiece());
            }else{
                track.get(pos-1).setPiece(track.get(pos).removePiece());
            }
            if(onStartingPosition() || onEnemyLine())
                going=!going;
            return true;
        }
        return false;
    }

    public boolean fastTunnelMovement() {
        int pos;
        try {
            pos = getPiecePositionNumber();
        } catch (MyException ex) {
            return false;
        }
        if(!onStartingPosition()&&!onEnemyLine()){
            if(going){
                track.get(N_TUNNEL_SPACES+1).setPiece(track.get(pos).removePiece());
            }else{
                track.get(0).setPiece(track.get(pos).removePiece());
            }
            going=!going;
            return true;
        }
        return false;
        
    }

    public boolean getInsideTunnelMovement() {
        int pos;
        try {
            pos = getPiecePositionNumber();
        } catch (MyException ex) {
            return false;
        }
        if(onStartingPosition()|| onEnemyLine()){
            if(going){
                track.get(pos+1).setPiece(track.get(pos).removePiece());
            }else{
                track.get(pos-1).setPiece(track.get(pos).removePiece());
            }
            return true;
        }
        return false;
    }
    
}
