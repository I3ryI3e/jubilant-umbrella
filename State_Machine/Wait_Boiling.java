package State_Machine;

import Model.Game;

public class Wait_Boiling extends State_Adapter{
    public Wait_Boiling(Game g) {super(g);}

    @Override
    public States Apply_Action_Rules(Enemy_Attack ea) {
        getGame().boiling(ea);
        return new Wait_Action(getGame());
    }

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }
}
