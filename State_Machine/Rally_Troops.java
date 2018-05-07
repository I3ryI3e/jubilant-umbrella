package State_Machine;

import Model.Game;

public class Rally_Troops extends State_Adapter{

    public Rally_Troops(Game g) {
        super(g);
    }
    
    @Override
    public States Apply_Action_Rules(Enemy_Attack ea) {     //VARIAVEL ea NAO USADA
        getGame().rally();
        return new Rally_Troops(getGame());
    }

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }
}
