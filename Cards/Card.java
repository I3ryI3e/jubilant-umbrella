package Cards;

import Model.Constants;
import Model.Day;
import Model.Game;
import Model.MyException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Card implements Constants, Serializable{
    private final int card_number;
    private final ArrayList<Day> days;
    
    public Card(int cn){
        card_number=cn;
        days= new ArrayList<>();
    }
    
    public Day getDayX(int day){
        if(day > 0 && day < days.size())
            return days.get(day);
        return days.get(0);
    }
    
    public final boolean addDay(Day nd){
        if(days.size() < 3){
         days.add(days.size(), nd);
         return true;
        }
        return false;
    }
    
    public void resolve(int game_day, Game game){
            days.get(game_day).resolve(game);
    }

    public String printDayX(int game_day, int numberOfCardsPlayed) {
        StringBuilder str = new StringBuilder();
        str.append("{CARD}\nCard Number: ").append(card_number).append(" - (").append(numberOfCardsPlayed).append(" of 7)\n");
        str.append(days.get(game_day));
        return str.toString();
    }
}
