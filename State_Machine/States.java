package State_Machine;

import Model.*;
import java.io.Serializable;

public interface States extends Constants, Serializable{
    public States New_Game();
    public States Draw_Card();
    public States setActions(int na);
    public States archers();
    public States Rally_Troops();
    public States boiling();
    public States Tunnel();
    public States Apply_Action_Rules(Enemy_Attack ea);
    public States returnWaitAction();
    public States checkLossAnd2Enemy();

    public States endTurn();
}
