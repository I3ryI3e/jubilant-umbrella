package State_Machine;

import Model.Game;

public class Wait_Archers extends State_Adapter{
    public Wait_Archers(Game g) {super(g);}

    @Override
    public States Apply_Action_Rules(Enemy_Attack ea) {
        getGame().archers(ea);
        return new Wait_Action(getGame());
    }

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }
}
