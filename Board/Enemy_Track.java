
package Board;

import static Model.Constants.N_ENEMY_CIRCLES;
import static Model.Constants.N_ENEMY_CLOSE_COMBAT;
import static Model.Constants.TAM_TRACKS_ENEMY;
import Model.MyException;
import java.util.ArrayList;

public class Enemy_Track extends Track {

    public Enemy_Track(Piece p) {
        track = new ArrayList<>(TAM_TRACKS_ENEMY);
        int i =0;
        for (; i < N_ENEMY_CLOSE_COMBAT; i++) {
            track.add(i, new Close_Combat_Square());
        }
        for(; i < N_ENEMY_CLOSE_COMBAT+N_ENEMY_CIRCLES;i++){
            track.add(i, new Circle());
        }
        for(; i< TAM_TRACKS_ENEMY;i++){
            if(i==TAM_TRACKS_ENEMY-1){
                track.add(i,new Square(p));
            }else
                track.add(i, new Square());
        }
        
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
    
}
