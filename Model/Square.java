
package Model;

public class Square implements Position {
    public Piece piece;

    public Square() {
        piece= null;
    }
    public Square(Piece w){
        piece=w;
    }
    @Override
    public boolean hasPiece() {
        return piece != null;
    }

    @Override
    public void setWeapon(Weapon w) {
        if(w!= null)
            piece = w;
    }
    
}
