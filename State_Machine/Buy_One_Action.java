
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
        if(getGame().isRaidAndSabEventActive())
            return new Only_Raid_and_Sab_State(getGame());
        else if (getGame().TwoEnemyLine())
            return new Close_Combat(getGame());
        return new Wait_Action(getGame());
    }
    
    
}
