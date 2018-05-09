
package Board;

import static Model.Constants.N_ENEMY_CIRCLES;
import static Model.Constants.N_ENEMY_CLOSE_COMBAT;
import static Model.Constants.TAM_TRACKS_ENEMY;
import Model.MyException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            pos = getPiecePositionNumber();
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
            pos = getPiecePositionNumber();
        } catch (MyException ex){
            return;
        }
        if(pos<track.size()-1){
            track.get(pos+1).setPiece(track.get(pos).removePiece());
        }
    }

    @Override
    public boolean onStartingPosition() {
        try {
            return getPiecePositionNumber() == TAM_TRACKS_ENEMY-1;
        } catch (MyException ex) {
            return false;
        }
    }
    

    public int getStrength() throws MyException {
        Position aux=getPiecePosition(getPiecePositionNumber());
        if(aux instanceof Close_Combat_Square)
            return 4;
        else if(aux.getPiece() instanceof Ladder)
            return 2;
        else if (aux.getPiece() instanceof Battering_Ram)
            return 3;
        else
            return 4;
    }
    public boolean onCloseCombat(){
        try {
            return (getPiecePosition(getPiecePositionNumber()) instanceof Close_Combat_Square);
        } catch (MyException ex) {
            return false;
        }  
    }

    boolean onCircleSpace() {
        try{
            return (getPiecePosition(getPiecePositionNumber()) instanceof Circle);
        }catch (MyException ex){
            return false;
        }
    }
    
}
