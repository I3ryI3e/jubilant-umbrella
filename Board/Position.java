package Board;

import Card_Events.Event;
import java.io.Serializable;

public abstract class Position implements Serializable{
    private Piece piece;

    public Position() {piece = null;}
    
    public Position(Piece p){piece=p;}
    
    public boolean hasPiece(){return piece != null;}
    
    public void setPiece(Piece p){
        if(p != null)
            piece=p;
    }
    
    public Piece removePiece(){
        Piece aux;
        aux=piece;
        piece = null;
        return aux;
    }
    
    public Piece getPiece(){return piece;}

    public int getPositionModifier(Event event){return 0;}
}
