package State_Machine;

import Model.Game;
import Model.MyException;

public class Wait_Draw_Card extends State_Adapter {
    public Wait_Draw_Card(Game g){super(g);}

    @Override
    public States Draw_Card() {
        getGame().drawAndResolveCard();
        if(getGame().checkLoss())
            return new Game_Over(getGame());
        else if(getGame().TwoEnemyLine())
            return new Close_Combat(getGame());
        return new Wait_Action(getGame());
    }

    @Override
    public States enemyCheckLine() {
        getGame().enemyCheckLine();
        return this;
    }
    
}
