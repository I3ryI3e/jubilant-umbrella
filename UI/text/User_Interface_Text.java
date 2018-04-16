package UI.text;

import Model.*;
import State_Machine.*;
import java.util.Scanner;

public class User_Interface_Text {
    private Siege_Game game;
    private boolean quit = false;
    
    public User_Interface_Text(Siege_Game g){
        this.game=g;
    }
    
    private int read_int(){
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt()){
            in.next();
        }
        return in.nextInt();
    }

    public void initial_text(){
        int option;
        System.out.println("\n9 CARD SIEGE!!\n");
        System.out.println("\t1- New Game\n\t2- Load Game\n\t3- Quit");
        option=read_int();
        switch(option){
            case 1:
                game.setup();
                break;
            case 2:
                game.load();
                break;
            case 3:
                quit = true;
            default:
                break;
        }  
    }
    
    public void wait_action_text(){
        int option;
        System.out.println("\n9 CARD SIEGE!!\n");
        System.out.println((game.can_archers()?"\t1- Archers Attack\n":"") + (game.can_boilling()?"\t2- Boilling Water Attack\n":"") + 
                (game.can_close_combat()?"\t3- Close Combat Attack\n":"") + (game.can_coupure()?"\t4- Coupure\n":"") + 
                (game.can_rally()?"\t5- Rally Troops\n":"") + "\t6- Tunnel Movement\n" + (game.can_supply()?"\t7- Supply Raid\n":"") + 
                (game.can_sabotage()?"\t8- Sabotage\n":"") + "\n\n9- Save Game");
        option = read_int();
        int dice = (int) (Math.random()*5+1);
        switch(option){
            case 1:
                System.out.println(game.getGame().getEnemy().enemy_location());
                System.out.println("Which one to atack:  " + (!game.is_ladder(4)?"1- Ladder":"") +
                        (!game.is_battering_ram(4)?"2- Battering Ram":"") + (!game.is_siege_tower(4)?"3- Siege Tower":""));
                //  FINNISH THIS!!!
                game.archers(dice);
                break;
            case 2:
                game.boilling(dice);
                break;
            case 3:
                game.close_combat(dice);
                break;
            case 4:
                game.coupure(dice);
                break;
            case 5:
                game.rally(dice);
                break;
            case 6:
                game.tunnel();
                break;
            case 7:
                game.supply(dice);
                break;
            case 8:
                game.sabotage(dice);
            default:
                break;
        }
    }
    
//    public void draw_card_text(){
//        
//    }
    
    public void run(){
        
        States state = game.getState();
        while(!quit){
            if( state instanceof Initial_State){
                initial_text();
            }else if ( state instanceof Wait_Action){
                wait_action_text();
            }
        }
    }
    
    public static void main() {
        Siege_Game origin = new Siege_Game();
        User_Interface_Text ui_text = new User_Interface_Text(origin);
        ui_text.run();
    }
}
