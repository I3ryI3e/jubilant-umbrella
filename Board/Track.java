
package Board;

import Model.Constants;
import Model.MyException;
import java.io.Serializable;
import java.util.List;

public abstract class Track implements Constants, Serializable{
    protected List<Position> track;

    public void removeFromGame() {
        if(track.get(TAM_TRACKS_ENEMY-1).hasPiece())
                track.get(TAM_TRACKS_ENEMY-1).removePiece();
    }
    public int getPiecePositionNumber() throws MyException{                           //If doesn't exists a piece.
        for (int i = 0; i < track.size(); i++) {
            if(track.get(i).hasPiece())
                return i;
        }
        throw new MyException();
    }

    public int getTrackSize(){
        return track.size();
    }
    
    Position getPiecePosition(int piecePosition) {
        return track.get(piecePosition);
    }
    public abstract boolean onStartingPosition();
    public boolean exists(){
        for (Position position : track) {
            if(position.getPiece()!= null)
                return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        try {
            return "["+ track.get(getPiecePositionNumber()).getPiece().getName() + " is on " + getPiecePositionNumber() + " position]\t\t";
        } catch (MyException ex) {
            return "";
        }
    }
    
}
