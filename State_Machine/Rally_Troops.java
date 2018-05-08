package State_Machine;

import Model.Game;

public class Rally_Troops extends State_Adapter{

    public Rally_Troops(Game g) {
        super(g);
    }

    @Override
    public States Apply_Rally_Rules(boolean check) {
        getGame().rally(check);
        return new Wait_Action(getGame());
    }

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }
}
