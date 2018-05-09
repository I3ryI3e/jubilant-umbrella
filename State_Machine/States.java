package State_Machine;

import Model.*;
import java.io.Serializable;

public interface States extends Constants, Serializable{
    public States New_Game();
    public States Draw_Card() throws MyException;
    public States setActions(int na);
    public States archers();
    public States Rally_Troops();
    public States boiling();
    public States closeCombat();
    public States coupure();
    public States sabotage();
    public States Tunnel();
    public States Apply_Action_Rules(Enemy_Attack ea);
    public States Apply_Rally_Rules(boolean check);
    public States returnWaitAction();
    public States checkLossAnd2Enemy();

    public States endTurn();

    public States automaticTunnelMovement();

    public States fastTunnelMovement();

    public States getInsideTunnelMovement();

    public States BuyAction();
    public States BuyAction(int opt);
}
