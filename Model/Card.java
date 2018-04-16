package Model;

import java.util.ArrayList;

public class Card {
    private final int card_number;
    private final ArrayList<Day> days;
    
    public Card(int cn){
        card_number=cn;
        days= new ArrayList<>();
    }
    public boolean addDay(Day nd){
        if(days.size() < 3){
         days.add(nd);
         return true;
        }
        return false;
    }
}
