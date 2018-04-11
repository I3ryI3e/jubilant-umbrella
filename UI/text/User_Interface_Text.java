package UI.text;

import Model.*;
import java.util.Scanner;


public class User_Interface_Text {
    private Game game;
    
    public User_Interface_Text(Game g){
        this.game=g;
    }
    
    private int read_int(){
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt()){
            in.next();
        }
        return in.nextInt();
    }

    
    public void run(){
        int option;
        boolean quit=false;
        while(!quit){
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
        quit = false;
        while(!quit){
            
        }
    }
    public static void main() {
        Game origin = new Game();
        User_Interface_Text ui_text = new User_Interface_Text(origin);
        ui_text.run();
    }
}
