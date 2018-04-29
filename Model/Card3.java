
package Model;

import Card_Events.*;
import java.util.ArrayList;
import java.util.List;

public class Card3 extends Card{
    
    public Card3() {
        super(3);
        List<Constants.Enemy_Attack> aux = new ArrayList<>();
        aux.add(Constants.Enemy_Attack.LADDERS);
        addDay(new Day(2,aux,new Supplies_Spoiled()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.NONE);
        addDay(new Day(2,aux,new Bad_Weather()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.LADDERS);
        aux.add(Constants.Enemy_Attack.BATTERING_RAM);
        addDay(new Day(2,aux,new Boiling_Oil()));
    }
    
}
