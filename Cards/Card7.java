
package Cards;

import Card_Events.*;
import Model.Constants;
import Model.Day;
import java.util.ArrayList;
import java.util.List;

public class Card7 extends Card {
    
    public Card7() {
        super(7);
        List<Constants.Enemy_Attack> aux = new ArrayList<>();
        aux.add(Constants.Enemy_Attack.BATTERING_RAM);
        addDay(new Day(3,aux,new Determined_Enemy()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.SIEGE_TOWER);
        addDay(new Day(2,aux,new Iron_Shields()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.BATTERING_RAM);
        aux.add(Constants.Enemy_Attack.LADDERS);
        aux.add(Constants.Enemy_Attack.SIEGE_TOWER);
        addDay(new Day(2,aux,new Faith()));
    }
    
}
