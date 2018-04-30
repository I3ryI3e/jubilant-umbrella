
package Board;

import Model.Constants;
import Model.MyException;
import java.util.ArrayList;
import java.util.List;

public class Track implements Constants {
    public List<Position> track;

    public Track(Piece w) {
        int i=0;
        if(w instanceof Weapon){
            track = new ArrayList<>(TAM_TRACKS_ENEMY);
            for (; i < N_ENEMY_CLOSE_COMBAT; i++) {
                track.set(i, new Close_Combat_Square());
            }
            for(; i < N_ENEMY_CLOSE_COMBAT+N_ENEMY_CIRCLES;i++){
                track.set(i, new Circle());
            }
            for(; i< TAM_TRACKS_ENEMY;i++){
                if(i==TAM_TRACKS_ENEMY-1){
                    track.set(i,new Square(w));
                }else
                    track.set(i, new Square());
            }
        }else{
            track = new ArrayList<>(N_PLAYER_SQUARES);
            for(;i < N_PLAYER_SQUARES;i++){
                if(i==N_PLAYER_SQUARES-1)
                    track.set(i, new Square(w));
                else
                    track.set(i, new Square());
            }
        }
    }

    public void removeFromGame() {
        if(track.get(0).hasPiece())
                track.get(0).removePiece();
    }
    public int getPiecePosition() throws MyException{  //If doesn't exists a piece.
        for (int i = 0; i < track.size(); i++) {
            if(track.get(i).hasPiece())
                return i;
        }
        throw new MyException();
    }

    public void goForward() {
        int pos;
        try {
            pos = getPiecePosition();
        } catch (MyException ex) {
            return;
        }
        if(pos>0){
            track.get(pos-1).setPiece(track.get(pos).removePiece());
        }
    }

    public void goBackward() {
        int pos;
        try{
            pos = getPiecePosition();
        } catch (MyException ex){
            return;
        }
        if(pos<track.size()-1){
            track.get(pos+1).setPiece(track.get(pos).removePiece());
        }
    }
    public int getTrackSize(){
        return track.size();
    }
}
