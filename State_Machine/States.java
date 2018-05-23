package State_Machine;

import Model.*;
import java.io.Serializable;

public interface States extends Constants, Serializable{
    public States New_Game();
    public States Draw_Card() throws MyException;
    public States setActions(int na);
    public States archers();
    public States rally_Troops();
    public States boiling();
    public States closeCombat();
    public States coupure();
    public States sabotage();
    public States supply();
    public States tunnel();
    public States freeTunnelMovement();
    public States fastTunnelMovement();
    public States getInsideTunnelMovement();
    public States buyAction();
    public States buyAction(int opt);
    public States Apply_Action_Rules(Enemy_Attack ea);
    public States Apply_Rally_Rules(boolean check);
    public States returnWaitAction();
    public States returnInitialState();
    public States endTurn();
}
