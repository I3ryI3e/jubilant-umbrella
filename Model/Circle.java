
package Model;

public class Circle implements Position {
    public Weapon weapon;
            
    public Circle() {
        weapon=null;
    }
    @Override
    public boolean hasPiece() {
        return weapon != null;
    }

    @Override
    public void setWeapon(Weapon w) {
        if(w != null)
            weapon=w;
    }
    
}
