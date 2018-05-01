package State_Machine;

import Model.Game;

public class Wait_Draw_Card extends State_Adapter {
    
    
    public Wait_Draw_Card(Game g){
        super(g);
    }
    
    @Override
    public States Draw_Card(){
        getGame().drawAndResolveCard();
        return new Wait_Action(getGame());
    }

    @Override
    public States setActions(int na) {
        getGame().getPlayer().setActions(na);
        return this;
    }
    
    
}
