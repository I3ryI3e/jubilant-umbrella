package State_Machine;

import Model.*;

public class Wait_Action extends State_Adapter implements Constants{

    public Wait_Action(Game g){
        super(g);
    }
    @Override
    public States archers(int dice, Enemy_Attack enemy_mov) {
        getGame().archers(dice, enemy_mov);
        return this;
    }
}
