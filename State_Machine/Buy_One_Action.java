
package State_Machine;

import Model.*;

public class Buy_One_Action extends State_Adapter {

    public Buy_One_Action(Game g) {
        super(g);
    }

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }

    @Override
    public States BuyAction(int opt) {
        getGame().buyAction(opt);
        return new Wait_Action(getGame());
    }
    
    
}
