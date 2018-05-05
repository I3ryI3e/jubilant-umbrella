
package Board;

import Model.MyException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tunnel_Track extends Track{
    
    public Tunnel_Track(Piece p){
        track = new ArrayList<>(N_TUNNEL_SPACES+2);
        track.add(new Castle_Position(p));
        for(int i=0;i < N_TUNNEL_SPACES;i++){
            track.add(new Square());
        }
        track.add(new Enemy_Line_Position());
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

    void soldiersDiedOnEnemyLines() {
        track.get(0).setPiece(track.get(N_ENEMY_SQUARES-1).removePiece());
    }
    
}
