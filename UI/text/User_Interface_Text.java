package UI.text;

import Model.*;
import State_Machine.*;
import java.io.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User_Interface_Text implements Constants, Observer{
    private Siege_Game game;
    private boolean quit = false;
    
    public User_Interface_Text(){
        this.game= new Siege_Game(this);
    }

    public void setGame(Siege_Game game) {
        this.game = game;
    }
    
    private int read_int(){
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt()){
            in.next();
        }
        return in.nextInt();
    }
    
    private String read_Text(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
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
                load_text();
                break;
            case 3:
                quit = true;
            default:
                break;
        }  
    }
    
    public void wait_action_text(){
        int option;
        System.out.println(game.drawBoards());
        System.out.println(game.drawCardDay());
        System.out.println(wait_action_text_menu());
        option = read_int();
        switch(option){
            case 1:
                game.stateArchers();
                break;
            case 2:
                game.stateBoilling();
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
                break;
            case 9:
                save_text();
                break;
            case 10:
                game.endTurn();
                break;
            case 11:
                quit = true;
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
        
        str.append("\t9- Save game\n\t10- End Turn\n" + "\n\t11- Quit\n");
        
        return str.toString();
    }
    
    public void draw_card_text(){
        int option;
        System.out.println("\n\t1- Draw card\n" + "\t2- Save game\n" + "\t3- Load game\n" + "\t4- Quit\n");
        option = read_int();
        switch(option){
            case 1:
                game.drawCard();
                break;
            case 2:
                save_text();
                break;
            case 3:
                load_text();
                break;
            case 4:
                quit=true;
        }
    }
    
    private void archersText() {
        int opt;
        StringBuilder str = new StringBuilder();
        System.out.println(game.getGame().getEnemy());
        try {
            str.append((game.isLadder(TAM_TRACKS_ENEMY-1)?"":"\t1- Ladder\n"));
        } catch (MyException e) {}
        try {
            str.append((game.isBatteringRam(TAM_TRACKS_ENEMY-1)?"":"\t2- Battering Ram\n"));
        } catch (MyException e) {}
        try {
            str.append((game.isSiegeTower(TAM_TRACKS_ENEMY-1)?"":"\t3- Siege Tower\n"));
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
    // SIMILAR FUNCITONS - REWATCH AND SEE IF ITS POSSIBLE TO JOIN THEM
    private void boillingText() {
        int opt;
        StringBuilder str = new StringBuilder();
        System.out.println(game.getGame().getEnemy());
        try {
            str.append((game.isLadder((TAM_TRACKS_ENEMY-N_ENEMY_SQUARES)-1)?"":"\t1- Ladder\n"));       // -1 BECAUSE THE LIST POSITION ZERO
        } catch (MyException e) {}
        try {
            str.append((game.isBatteringRam((TAM_TRACKS_ENEMY-N_ENEMY_SQUARES)-1)?"":"\t2- Battering Ram\n"));
        } catch (MyException e) {}
        try {
            str.append((game.isSiegeTower((TAM_TRACKS_ENEMY-N_ENEMY_SQUARES)-1)?"":"\t3- Siege Tower\n"));
        } catch (MyException e) {}
        str.append("\t4- return\n");
        System.out.println(str.toString());
        
        opt = read_int();
        
        switch(opt){
            case 1:
                game.boilling(Enemy_Attack.LADDER);
            case 2:
                game.boilling(Enemy_Attack.BATTERING_RAM);
            case 3:
                game.boilling(Enemy_Attack.SIEGE_TOWER);
            case 4:
                game.returnWaitAction();
        }
    }
    
    public void run(){
        States state =null;
        while(!quit){
            state = game.getState();
            game.checkLossAnd2Enemy();
            if( state instanceof Initial_State){
                initial_text();
            }else if (state instanceof Wait_Draw_Card){
                draw_card_text();
            }else if( state instanceof Wait_Action){
                wait_action_text();
            }else if ( state instanceof Wait_Archers) {
                archersText();
            }else if ( state instanceof Wait_Boiling) {
                boillingText();
//            }else if (state instanceof Game_Over){
//                gameOver_Text();
            }
        }
    }
    
    public static void main(String[] args) {
        User_Interface_Text ui_text = new User_Interface_Text();
        ui_text.run();
    }
    
    private void load_text() {
        System.out.print("\nName of the file to load:  ");
        String filename = read_Text();
        if(filename == null || filename.isEmpty())
                return;
        setGame(load_game(filename));
        System.out.println("\nGame loaded\n");
    }

    private Siege_Game load_game(String filename) {
        ObjectInputStream oistream = null;
        Siege_Game sg = null;
        
        try {
            oistream = new ObjectInputStream(new FileInputStream(filename));
            sg = (Siege_Game) oistream.readObject();
        } catch (FileNotFoundException ex) {
            System.err.println("Erro: ficheiro inexistente\n" + ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(User_Interface_Text.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(oistream != null){
                try {
                    oistream.close();
                } catch (IOException ex) {
                    Logger.getLogger(User_Interface_Text.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return sg;
    }
    
    private void save_text(){
        System.out.println("\nName of the file to save: ");
        String filename = read_Text();
        if(filename == null || filename.isEmpty())
            return;
        save_game(filename);
        System.out.println("\nGame saved\n");
    }
    
    private void save_game(String filename) {
        ObjectOutputStream oostream = null;
        
        try {
            oostream = new ObjectOutputStream(new FileOutputStream(filename));
            oostream.writeObject(this.game);
        } catch (FileNotFoundException ex) {
            System.err.println("Erro: ficheiro inexistente\n" + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(User_Interface_Text.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(oostream != null){
                try {
                    oostream.close();
                } catch (IOException ex) {
                    Logger.getLogger(User_Interface_Text.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(game.getText());
    }
}
