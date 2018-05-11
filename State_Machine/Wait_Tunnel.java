package State_Machine;

import Model.Game;

public class Wait_Tunnel extends State_Adapter{
    public Wait_Tunnel(Game g) {super(g);}

    @Override
    public States freeTunnelMovement() {
        if(getGame().automaticTunnelMovement())
            return new Wait_Action(getGame());
        return this;
    }

    @Override
    public States fastTunnelMovement() {
        if(getGame().fastTunnelMovement())
            return new Wait_Action(getGame());
        return this;
    }

    @Override
    public States getInsideTunnelMovement() {
        if(getGame().getInsidetunnelMovement())
            return new Wait_Action(getGame());
        return this;
    }

    @Override
    public States returnWaitAction() {
        return new Wait_Action(getGame());
    }
}
