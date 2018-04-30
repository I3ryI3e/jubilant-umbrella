
package Board;

import Board.Weapon;

public class Ladder implements Weapon {

    @Override
    public int getPower() {
        return 2;
    }

    @Override
    public String getName() {
        return "Ladder";
    }
    
    
}
