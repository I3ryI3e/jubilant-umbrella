
package Board;

import Model.Event;

public class Circle extends Position {
            
    public Circle() {
        super();
    }
    public Circle(Piece p){
        super(p);
    }

    @Override
    public int getPositionModifier(Event event) {
        return event.getCircleAttackMod();
    }
    
    
}
