
package Board;

import Model.Constants;
import Model.MyException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Track implements Constants {
    protected List<Position> track;

    public void removeFromGame() {
        if(track.get(0).hasPiece())
                track.get(0).removePiece();
    }
    public int getPiecePosition() throws MyException{                           //If doesn't exists a piece.
        for (int i = 0; i < track.size(); i++) {
            if(track.get(i).hasPiece())
                return i;
        }
        throw new MyException();
    }

    public int getTrackSize(){
        return track.size();
    }

    @Override
    public String toString() {
        try {
            return track.get(getPiecePosition()).getPiece().getName() + " is on " + getPiecePosition() + " position\n";
        } catch (MyException ex) {
            Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Erro nas Tracks to String";
    }
    
}
