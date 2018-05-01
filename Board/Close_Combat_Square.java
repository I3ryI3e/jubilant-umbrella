
package Board;

import Model.Event;

public class Close_Combat_Square extends Position {
    
    public Close_Combat_Square() {
        super();
    }
    public Close_Combat_Square(Piece p){
        super(p);
    }

    @Override
    public int getPositionModifier(Event event) {
        return event.getCloseCombatMod();
    }
    
    
}
