package State_Machine;

import Model.Game;

public class Close_Combat extends State_Adapter{
   
    public Close_Combat(Game g){
        super(g);
    }

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }

    @Override
    public States Apply_Action_Rules(Enemy_Attack ea) {
        getGame().closeCombat(ea);
        if(getGame().getPlayer().checkLoss())
            return new Game_Over(getGame());
        else{
            if(getGame().getEnemy().isNumEnemyInCloseCombat(2) && getGame().getPlayer().playerStillHasActionsLeft())
                return this;
            else   
                return new Wait_Action(getGame());
        }
    }
}
