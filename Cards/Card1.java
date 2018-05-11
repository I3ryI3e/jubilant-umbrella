package Cards;

import Card_Events.*;
import Model.Constants.Enemy_Attack;
import Model.Day;
import java.util.ArrayList;
import java.util.List;

public class Card1 extends Card {
    public Card1() {
        super(1);
        List<Enemy_Attack> aux = new ArrayList<>();
        aux.add(Enemy_Attack.NONE);
        addDay(new Day(3,aux,new Trebuchet_Attack()));
        addDay(new Day(2,aux,new Trebuchet_Attack()));
        addDay(new Day(1,aux,new Trebuchet_Attack()));
    }
}
