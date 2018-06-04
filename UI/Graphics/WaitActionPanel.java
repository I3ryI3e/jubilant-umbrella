
package UI.Graphics;

import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Action;
import State_Machine.Wait_Draw_Card;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitActionPanel extends JPanel implements Observer {
    private Siege_Game game;
    private JButton archersButton;
    private JButton boilingButton;
    private JButton closeCombatButton;
    private JButton coupureButton;
    private JButton rallyTroopsButton;
    private JButton tunnelButton;
    private JButton supplyRaidButton;
    private JButton sabotageButton;
    private JButton buyActionButton;
    private JButton endTurnButton;
    
    public WaitActionPanel(Siege_Game game) {
        super();
        this.game=game;
        game.addObserver(this);
        setVisible(false);
        
        createObjects();
        orderLayout();
        registerListeners();
        
        update(game,null);
        
    }
    private void createObjects() {
        archersButton= new JButton("Archers Attack");
        boilingButton= new JButton("Boiling Attack");
        closeCombatButton= new JButton("Close Combat Attack");
        coupureButton= new JButton("Coupure");
        rallyTroopsButton= new JButton("Rally Troops");
        tunnelButton= new JButton("Tunnel Movement");
        supplyRaidButton= new JButton("Supply Raid");
        sabotageButton= new JButton("Sabotage");
        buyActionButton= new JButton("Buy Action");
        endTurnButton= new JButton("End Turn");
    }

    private void orderLayout() {
        setLayout(new GridLayout(2, 5));
        add(archersButton);
        add(boilingButton);
        add(closeCombatButton);
        add(coupureButton);
        add(rallyTroopsButton);
        add(tunnelButton);
        add(supplyRaidButton);
        add(sabotageButton);
        add(buyActionButton);
        add(endTurnButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
    }
    

    private void registerListeners() {
        //TODO
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void update(Observable o, Object arg) {
        States state=game.getState();
        if(state instanceof Wait_Action){
            setVisible(true);
        }
        
    }

    
    
    
}
