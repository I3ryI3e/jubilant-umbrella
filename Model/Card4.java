
package Model;

import Card_Events.*;
import java.util.ArrayList;
import java.util.List;

public class Card4 extends Card{
    
    public Card4() {
        super(4);
        List<Constants.Enemy_Attack> aux = new ArrayList<>();
        aux.add(Constants.Enemy_Attack.SIEGE_TOWER);
        aux.add(Constants.Enemy_Attack.LADDERS);
        addDay(new Day(2,aux,new Death_of_a_Leader()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.BATTERING_RAM);
        aux.add(Constants.Enemy_Attack.LADDERS);
        addDay(new Day(2,aux,new Gate_Fortified()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.SIEGE_TOWER);
        addDay(new Day(3,aux,new Flaming_Arrows()));
    }
}
