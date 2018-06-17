package State_Machine;

import Model.*;

public class Buy_One_Action extends State_Adapter {
    public Buy_One_Action(Game g) {super(g);}

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }

    @Override
    public States buyAction(int opt) {
        getGame().buyAction(opt);
        if(getGame().checkLoss())
            return new Game_Over(getGame());
        if (getGame().TwoEnemyLine())
            return new Close_Combat(getGame());
        return new Wait_Action(getGame());   
    }
}
