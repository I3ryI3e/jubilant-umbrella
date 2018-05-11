package Cards;

import Card_Events.*;
import Model.Constants.Enemy_Attack;
import Model.Day;
import java.util.ArrayList;
import java.util.List;

public class Card2 extends Card {
    public Card2() {
        super(2);
        List<Enemy_Attack> aux = new ArrayList<>();
        aux.add(Enemy_Attack.SIEGE_TOWER);
        addDay(new Day(2,aux,new Illness() ));
        aux.clear();
        aux.add(Enemy_Attack.SWORD);
        addDay(new Day(2,aux,new Guards_Distracted()));
        aux.clear();
        aux.add(Enemy_Attack.NONE);
        addDay(new Day(1,aux,new Trebuchet_Attack()));
    }
}
