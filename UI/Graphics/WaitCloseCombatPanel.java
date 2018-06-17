package UI.Graphics;

import Model.Constants;
import Model.ObservableGame;
import State_Machine.Close_Combat;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitCloseCombatPanel extends JPanel implements Observer {
    ObservableGame game;
    private JButton ladderButton;
    private JButton batteringRamButton;
    private JButton siegeTowerButton;
    private JButton returnToMenuButton;

    public WaitCloseCombatPanel(ObservableGame game) {
        this.game=game;
        this.game.addObserver(this);
        createObjects();
        orderLayout();
        registerListeners();
    }
    
    private void createObjects() {
        ladderButton= new JButton("Attack Ladder");
        batteringRamButton= new JButton("Attack Battering Ram");
        siegeTowerButton= new JButton("Attack Siege Tower");
        returnToMenuButton= new JButton("Return");
    }

    private void orderLayout() {
        setLayout(new GridLayout(4, 1));
        add(ladderButton);
        add(batteringRamButton);
        add(siegeTowerButton);
        add(returnToMenuButton);
    }

    private void registerListeners() {
        ladderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.closeCombat(Constants.Enemy_Attack.LADDER);
            }
        });
        batteringRamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.closeCombat(Constants.Enemy_Attack.BATTERING_RAM);
            }
        });
        siegeTowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.closeCombat(Constants.Enemy_Attack.SIEGE_TOWER);
            }
        });
        returnToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.returnWaitAction();
            }
        });
    }

    private void setButtons() {
        if(game.isLadderOnCloseCombat())
            ladderButton.setEnabled(true);
        else
            ladderButton.setEnabled(false);
        if(game.isBatteringRamOnCloseCombat())
            batteringRamButton.setEnabled(true);
        else
            batteringRamButton.setEnabled(false);
        if(game.isSiegeTowerOnCloseCombat())
            siegeTowerButton.setEnabled(true);
        else
            siegeTowerButton.setEnabled(false);
        if(game.check2Enemy())
            returnToMenuButton.setEnabled(false);
        else
            returnToMenuButton.setEnabled(true);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(game.getState() instanceof Close_Combat){
            setVisible(true);
            setButtons();
        }else
            setVisible(false);
    }   
}
