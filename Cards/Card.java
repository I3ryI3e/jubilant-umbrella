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
    }
    
    public final boolean addDay(Day nd){
        if(days.size() < 3){
         days.add(days.size(), nd);
         return true;
        }
        return false;
    }
}
