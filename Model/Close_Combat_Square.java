
package Model;

public class Close_Combat_Square implements Position {
    public Weapon weapon;

    public Close_Combat_Square() {
        weapon=null;
    }
    @Override
    public boolean hasPiece() {
        return weapon != null;
    }

    @Override
    public void setWeapon(Weapon w) {
        if(w!= null)
            weapon = w;
    }
    
}
