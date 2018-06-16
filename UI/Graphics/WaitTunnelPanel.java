package UI.Graphics;

import Model.ObservableGame;
import State_Machine.Wait_Tunnel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitTunnelPanel extends JPanel implements Observer{
    private ObservableGame game;
    private JButton freeMovement;
    private JButton fastMovement;
    private JButton getInMovement;
    private JButton returnButton;

    public WaitTunnelPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        createObjects();
        orderLayout();
        registerListeners();
        update(game,null);
    }
    
    private void createObjects() {
        freeMovement= new JButton("Make Free Movement");
        fastMovement= new JButton("Make Fast Movement");
        getInMovement= new JButton("Get into the tunnel");
        returnButton= new JButton("Return");
    }

    private void orderLayout() {
        setLayout(new GridLayout(4, 1));
        add(freeMovement);
        add(fastMovement);
        add(getInMovement);
        add(returnButton);
    }
    
    private void registerListeners() {
        freeMovement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.tunnelFree();
            }
        });
        fastMovement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.tunnelFast();
            }
        });
        getInMovement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.tunnelGetInside();
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.returnWaitAction();
            }
        });
    }

    private void setButtons() {
        if(game.canUseTunnelMovement() && game.canMakeFreeMove())
            freeMovement.setEnabled(true);
        else
            freeMovement.setEnabled(false);
        if(game.canUseTunnelMovement() && game.playerStillHasActionsLeft())
            fastMovement.setEnabled(true);
        else
            fastMovement.setEnabled(false);
        if((game.onCastleSpace() || game.onEnemyLine()) && game.playerStillHasActionsLeft())
            getInMovement.setEnabled(true);
        else
            getInMovement.setEnabled(false);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(game.getState() instanceof Wait_Tunnel){
            setVisible(true);
            setButtons();
        }else
            setVisible(false);
    }

    

    

    
    
    
}
