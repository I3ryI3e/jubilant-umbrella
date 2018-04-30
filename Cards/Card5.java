
package Cards;

import Card_Events.*;
import Model.Constants;
import Model.Day;
import java.util.ArrayList;
import java.util.List;

public class Card5 extends Card {
    
    public Card5() {
        super(5);
        List<Constants.Enemy_Attack> aux = new ArrayList<>();
        aux.add(Constants.Enemy_Attack.BATTERING_RAM);
        addDay(new Day(3,aux,new Volley_of_Arrows()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.BATTERING_RAM);
        aux.add(Constants.Enemy_Attack.LADDERS);
        addDay(new Day(2,aux,new Collapsed()));
        aux.clear();
        aux.add(Constants.Enemy_Attack.LADDERS);
        addDay(new Day(2,aux,new Repaired_Trebuchet()));
    }
    
}
