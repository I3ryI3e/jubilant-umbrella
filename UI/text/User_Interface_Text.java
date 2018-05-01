package UI.text;

import Model.*;
import State_Machine.*;
import java.util.Scanner;

public class User_Interface_Text implements Constants{
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
                //game.load();
                break;
            case 3:
                quit = true;
            default:
                break;
        }  
    }
    
    public void wait_action_text(){
        int option;
        System.out.println(wait_action_text_menu());
        option = read_int();
        switch(option){
            case 1:
                game.stateArchers();
                break;
            case 2:
                game.boilling();
                break;
            case 3:
                game.closeCombat();
                break;
            case 4:
                game.coupure();
                break;
            case 5:
                game.rally();
                break;
            case 6:
                //game.tunnel();
                break;
            case 7:
                game.supply();
                break;
            case 8:
                game.sabotage();
            default:
                break;
        }
    }
    
    public String wait_action_text_menu(){
        StringBuilder str = new StringBuilder();
        str.append("\nPlayer Action:\n");
        try {
            str.append((game.can_archers()?"\t1- Archers Attack\n":""));
        } catch (MyException e) {}
        try {
            str.append(game.can_boilling()?"\t2- Boilling Water Attack\n":"");
        } catch (MyException e) {}
        try {
            str.append(game.can_close_combat()?"\t3- Close Combat Attack\n":"");
        } catch (MyException e) {}
        try {
            str.append(game.canCoupure()?"\t4- Coupure\n":"");
        } catch (MyException e) {}
        try {
            str.append(game.canRally()?"\t5- Rally Troops\n":"");
        } catch (MyException e) {}
//        try {
//            str.append(game.canSupply()?"\t7- Supply Raid\n":"");
//        } catch (MyException e) {}
//        try {
//            str.append(game.canSabotage()?"\t8- Sabotage\n":"");
//        } catch (MyException e) {}
        
        str.append("\n\t9- Save game\n");
        
        return str.toString();
    }
    
    private void archersText() {
        int opt;
        StringBuilder str = new StringBuilder();
        System.out.println(game.getGame().getEnemy().enemyLocation());
        try {
            str.append((game.isLadder(TAM_TRACKS_ENEMY-1)?"\t1- Ladder\n":""));
        } catch (MyException e) {}
        try {
            str.append((game.isBatteringRam(TAM_TRACKS_ENEMY-1)?"\t2- Battering Ram\n":""));
        } catch (MyException e) {}
        try {
            str.append((game.isSiegeTower(TAM_TRACKS_ENEMY-1)?"\t3- Siege Tower\n":""));
        } catch (MyException e) {}
        str.append("\t4- return\n");
        System.out.println(str.toString());
        
        opt = read_int();
        
        switch(opt){
            case 1:
                game.archers(Enemy_Attack.LADDER);
            case 2:
                game.archers(Enemy_Attack.BATTERING_RAM);
            case 3:
                game.archers(Enemy_Attack.SIEGE_TOWER);
            case 4:
                game.returnWaitAction();
        }
    }
    
    public void draw_card_text(){
        int option;
        System.out.println("\n\t1- Draw card\n" + "\t2- Save game\n" + "\t3- Load game\n" + "\t4- Quit\n");
        option = read_int();
        switch(option){
            case 1:
                
                break;
            case 2:
                //game.saave();
                break;
            case 3:
                //game.load();
                break;
            case 4:
                return;
        }
    }
    
    public void run(){
        States state =null;
        while(!quit){
            state = game.getState();
            if( state instanceof Initial_State){
                initial_text();
            }else if (state instanceof Wait_Draw_Card){
                draw_card_text();
            }else if( state instanceof Wait_Action){
                wait_action_text();
            }else if ( state instanceof Wait_Archers) {
                archersText();
            }
        }
    }
    
    public static void main(String[] args) {
        Siege_Game origin = new Siege_Game();
        User_Interface_Text ui_text = new User_Interface_Text(origin);
        ui_text.run();
    }
}
