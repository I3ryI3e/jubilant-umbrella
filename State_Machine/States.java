package State_Machine;

import Model.*;

public interface States extends Constants{
    public States New_Game();
    public States Draw_Card();
    public States setActions(int na);
    public States archers();
    public States Rally_Troops();
    public States Boiling();
    public States Tunnel();
    public States Apply_Action_Rules(Enemy_Attack ea);
    public States returnWaitAction();
}
