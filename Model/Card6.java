
package Model;

import Card_Events.*;
import java.util.ArrayList;
import java.util.List;

public class Card6 extends Card {
    
    public Card6() {
        super(6);
        List<Constants.Enemy_Attack> aux = new ArrayList<>();
        aux.add(Constants.Enemy_Attack.SWORD);
        addDay(new Day(3,aux,new Cover_of_Darkness()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.LADDERS);
        addDay(new Day(3,aux,new Enemy_Fatigue()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.SIEGE_TOWER);
        aux.add(Constants.Enemy_Attack.BATTERING_RAM);
        addDay(new Day(3,aux,new Rally()));
    }
    
}
