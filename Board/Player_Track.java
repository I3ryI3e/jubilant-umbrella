package Board;

import static Model.Constants.N_PLAYER_SQUARES;
import Model.MyException;
import java.util.ArrayList;

public class Player_Track extends Track{

    public Player_Track(Piece p) {
        track = new ArrayList<>(N_PLAYER_SQUARES);
            for(int i=0;i < N_PLAYER_SQUARES;i++){
                if(i==N_PLAYER_SQUARES-1)
                    track.add(i, new Square(p));
                else
                    track.add(i, new Square());
            }
    }

    void raise() {
        int pos;
        try{
            pos = getPiecePositionNumber();
        } catch (MyException ex){
            return;
        }
        if(pos<track.size()-1){
            track.get(pos+1).setPiece(track.get(pos).removePiece());
        }
    }

    void decrease() {
        int pos;
        try {
            pos = getPiecePositionNumber();
        } catch (MyException ex) {
            return;
        }
        if(pos>0){
            track.get(pos-1).setPiece(track.get(pos).removePiece());
        }
    }
    
    @Override
    public boolean onStartingPosition() {
        try {
            return getPiecePositionNumber() == N_PLAYER_SQUARES-1;
        } catch (MyException ex) {
            return false;
        }
    }
    
    public boolean onSurrenderPosition(){
        try {
            return getPiecePositionNumber() == 0;
        } catch (MyException ex) {
            return false;
        }
    }
}
