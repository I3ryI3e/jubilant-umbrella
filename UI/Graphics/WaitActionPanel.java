
package UI.Graphics;

import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Action;
import State_Machine.Wait_Draw_Card;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setLayout(new GridLayout(5, 2));
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
    
    private void registerListeners() {
        archersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.stateArchers();
            }
        });
        endTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.endTurn();
            }
        });
    }
    private void setButtons(){
        if(game.canArchers())
            archersButton.setEnabled(true);
        else
            archersButton.setEnabled(false);
        if(game.canBoiling())
            boilingButton.setEnabled(true);
        else
            boilingButton.setEnabled(false);
        if(game.canCloseCombat())
            closeCombatButton.setEnabled(true);
        else
            closeCombatButton.setEnabled(false);
        if(game.canCoupure())
            coupureButton.setEnabled(true);
        else
            coupureButton.setEnabled(false);
        if(game.canRally())
            rallyTroopsButton.setEnabled(true);
        else 
            rallyTroopsButton.setEnabled(false);
        if(game.playerStillHasActionsLeft())
            tunnelButton.setEnabled(true);
        else
            tunnelButton.setEnabled(false);
        if(game.canSabotage())
            sabotageButton.setEnabled(true);
        else
            sabotageButton.setEnabled(false);
        if(game.canSupply())
            supplyRaidButton.setEnabled(true);
        else
            supplyRaidButton.setEnabled(false);
    }

    

    @Override
    public void update(Observable o, Object arg) {
        States state=game.getState();
        if(state instanceof Wait_Action){
            setVisible(true);
            setButtons();
        }
        else
            setVisible(false);
        
        
    }

    
    
    
}
