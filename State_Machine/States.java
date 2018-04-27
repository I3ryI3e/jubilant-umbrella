package State_Machine;

import Model.*;

public interface States {
    public States New_Game();
    public States Draw_Card();
    public States setActions(int na);
    public States archers(int dice, Constants.Enemy_Attack enemy_mov);
    public States Rally_Troops();
    public States Boiling();
    public States Tunnel();
    public States Apply_Action_Rules();
}
