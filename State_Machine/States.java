package State_Machine;

import Model.*;

public interface States {
    public States Draw_Card();
    public States Start_Game();
    public States setActions(int na);
    public States archers(int dice, Constants.Enemy_Attack enemy_mov);
}
