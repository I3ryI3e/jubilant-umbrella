package State_Machine;

public class Wait_Draw_Card extends Basic_State {
    
    @Override
    public States Draw_Card(){
        return new Wait_Action();
    }
}
