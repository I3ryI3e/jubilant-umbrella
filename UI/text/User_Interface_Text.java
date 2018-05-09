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
                game.stateCloseCombat();
                break;
            case 4:
                game.coupure();
                break;
            case 5:
                game.stateRally();
                break;
            case 6:
                game.stateTunnel();
                break;
            case 7:
                game.supply();
                break;
            case 8:
                game.sabotage();
                break;
            case 9:
                game.stateBuyAction();
                break;
            case 10:
                game.endTurn();
                break;
            case 11:
                save_text();
                break;
            case 12:
                quit=true;
        }
    }
    
    public String wait_action_text_menu(){
        StringBuilder str = new StringBuilder();
        str.append("\nPlayer Action:\n");

        str.append(game.can_archers()?"\t1- Archers Attack\n":"");
        str.append(game.can_boilling()?"\t2- Boilling Water Attack\n":"");
        str.append(game.can_close_combat()?"\t3- Close Combat Attack\n":"");
        str.append(game.canCoupure()?"\t4- Coupure\n":"");
        str.append(game.canRally()?"\t5- Rally Troops\n":"");
        str.append("\t6- Tunnel Action\n");
        str.append(game.canSupply()?"\t7- Supply Raid\n":"");
        str.append(game.canSabotage()?"\t8- Sabotage\n":"");
        str.append(game.canBuyAction()?"\t9- Buy Action\n":"");
        str.append("\t10- End Turn\n\t11- Save game\n" + "\n\t12- Quit\n");
        
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
        str.append((game.ladderOnStartingPosition()?"":"\t1- Ladder\n"));
        str.append((game.batteringRamOnStartingPosition()?"":"\t2- Battering Ram\n"));
        str.append((game.siegeTowerOnStartingPosition()?"":"\t3- Siege Tower\n"));
        str.append("\t4- return\n");
        System.out.println(str.toString());
        
        opt = read_int();
        
        switch(opt){
            case 1:
                game.archers(Enemy_Attack.LADDER);
                break;
            case 2:
                game.archers(Enemy_Attack.BATTERING_RAM);
                break;
            case 3:
                game.archers(Enemy_Attack.SIEGE_TOWER);
                break;
            case 4:
                game.returnWaitAction();
        }
    }
    
    private void boillingText() {
        int opt;
        StringBuilder str = new StringBuilder();
        System.out.println(game.getGame().getEnemy());
        str.append((game.isLadderOnCircleSpace()?"\t1- Ladder\n":""));
        str.append((game.isBatteringRamOnCircleSpace()?"\t2- Battering Ram\n":""));
        str.append((game.isSiegeTowerOnCircleSpace()?"\t3- Siege Tower\n":""));
        str.append("\t4- return\n");
        System.out.println(str.toString());
        
        opt = read_int();
        
        switch(opt){
            case 1:
                game.boilling(Enemy_Attack.LADDER);
                break;
            case 2:
                game.boilling(Enemy_Attack.BATTERING_RAM);
                break;
            case 3:
                game.boilling(Enemy_Attack.SIEGE_TOWER);
                break;
            case 4:
                game.returnWaitAction();
        }
    }
    
    private void rallyText() {
        int opt;
        StringBuilder str = new StringBuilder();
        System.out.println(game.getGame().getPlayer());
        str.append(((game.getGame().getPlayer().canDecreaseSupplies())?"\t1- Spend 1 morale to get +1DRM\n":"")).append("\t2- Normal try\n").append("\t3- return\n");
        System.out.println(str.toString());
        
        opt = read_int();
        
        switch(opt){
            case 1:
                game.rally(true);
            case 2:
                game.rally(false);
            case 3:
                game.returnWaitAction();
        }
    }
    
    private void onlyRaidAndSabText() { //TODO
        System.out.println("Only Raid and Sab Text");
        quit=true;
    }
    
    private void tunnelText(){
        int opt;
        StringBuilder str = new StringBuilder();
        System.out.println(game.getGame().getPlayer());
        str.append(game.canUseTunnelMovement()?(game.canMakeAutomaticMove()?"\t1- Automatic move\n\t2- Fast move":"\t2- Fast move"):(game.onEnemyLine()||game.onCastleSpace()?"\n\t3- Get inside the Tunnel":"")).append("\n\t4- Return");
        System.out.println(str.toString());
        opt = read_int();
        switch(opt){
            case 1:
                game.tunnelAuto();
                break;
            case 2:
                game.tunnelFast();
                break;
            case 3:
                game.tunnelGetInside();
                break;
            case 4:
                game.returnWaitAction();
        }
    }
    
    private void closeCombatText() {
        int opt;
        StringBuilder str = new StringBuilder();
        System.out.println(game.getGame().getEnemy());
        System.out.println("Still has "+game.getGame().numberOfActionsAvailable()+" left");
        str.append(game.isLadderOnCloseCombat()?"\t1- Attack Ladder\n":"");
        str.append(game.isBatteringRamOnCloseCombat()?"\t2- Attack Battering Ram\n":"");
        str.append(game.isSiegeTowerOnCloseCombat()?"\t1- Attack Siege Tower":"").append("\n\t4- Return");
        System.out.println(str.toString());
        opt = read_int();
        
        switch(opt){
            case 1:
                game.closeCombat(Enemy_Attack.LADDER);
                break;
            case 2:
                game.closeCombat(Enemy_Attack.BATTERING_RAM);
                break;
            case 3:
                game.closeCombat(Enemy_Attack.SIEGE_TOWER);
                break;
            case 4:
                game.returnWaitAction();
        }
    }
    
    private void buyOneActionText() {
        int opt;
        StringBuilder str = new StringBuilder();
        System.out.println(game.getGame().getPlayer());
        str.append(game.canDecreaseSupply()?"\t1- Use one supply to get one more action\n":"").append(game.canDecreaseMorale()?"\t2- Use one morale to get one more action":"").append("\n\t3- Return");
        System.out.println(str.toString());
        opt = read_int();
        
        switch(opt){
            case 1: case 2:
                game.buyAction(opt);
                break;
            case 3:
                game.returnWaitAction();
        }
    }

    private void gameOver_Text() {
        System.out.println("GAME OVER!");
        quit=true;
    }
    
    public void run(){
        States state =null;
        while(!quit){
            game.checkLossAnd2Enemy();
            state = game.getState();
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
            }else if ( state instanceof Rally_Troops) {
                rallyText();
            }else if (state instanceof Game_Over){
                gameOver_Text();
            }else if (state instanceof Only_Raid_and_Sab_State){
                onlyRaidAndSabText();
            }else if (state instanceof Wait_Tunnel){
                tunnelText();
            }else if (state instanceof Close_Combat){
                closeCombatText();
            }else if (state instanceof Buy_One_Action){
                buyOneActionText();
            }
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(game.getText());
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


    
}
