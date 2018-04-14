package State_Machine;

import Model.Game;

public class Wait_Draw_Card extends State_Adapter {
    
    
    public Wait_Draw_Card(Game g){
        super(g);
    }
    
    @Override
    public States Draw_Card(){
        return new Wait_Action(getGame());
    }
}
