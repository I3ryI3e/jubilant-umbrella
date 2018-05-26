package State_Machine;

import Model.Game;

public class Rally_Troops extends State_Adapter{
    public Rally_Troops(Game g) {super(g);}

    @Override
    public States Apply_NormalRally_Rules() {
        getGame().normalRally();
        return new Wait_Action(getGame());
    }
    
    @Override
    public States Apply_RallyPlus1DRM_Rules() {
        getGame().rallyPlus1DRM();
        return new Wait_Action(getGame());
    }

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }
}
