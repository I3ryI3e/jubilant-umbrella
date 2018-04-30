package Cards;

import Model.Constants;
import Model.Day;
import java.util.ArrayList;

public abstract class Card implements Constants {
    private final int card_number;
    private final ArrayList<Day> days;
    
    public Card(int cn){
        card_number=cn;
        days= new ArrayList<>();
    }
    
    public Day getDayX(int day){
        if(day > 0 && day < days.size())
            return days.get(day);
        //FAZER TRY CATCH THROW SHIT STUFF WHATEVER
        return days.get(0); //TESTES!
    }
    
    public final boolean addDay(Day nd){
        if(days.size() < 3){
         days.add(days.size(), nd);
         return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        aux.append("Card Number: ").append(card_number).append("\n");
        for (int i = 0; i < days.size(); i++) {
            aux.append(days.get(i));
        }
        return aux.toString();
    }
    
}
