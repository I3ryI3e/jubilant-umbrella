package UI.Graphics;

import Model.Constants;
import Model.ObservableGame;
import State_Machine.Wait_Boiling;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitBoilingWater extends JPanel implements Observer {
    ObservableGame game;
    private JButton ladderButton;
    private JButton batteringRamButton;
    private JButton siegeTowerButton;
    private JButton returnToMenuButton;

    public WaitBoilingWater(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        setVisible(false);
        createObjects();
        orderLayout();
        registerListener();
        update(game,null);
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

    private void registerListener() {
        ladderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.boiling(Constants.Enemy_Attack.LADDER);
            }
        });
        batteringRamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.boiling(Constants.Enemy_Attack.BATTERING_RAM);
            }
        });
        siegeTowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.boiling(Constants.Enemy_Attack.SIEGE_TOWER);
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
        if(game.isLadderOnCircleSpace())
            ladderButton.setEnabled(true);
        else
            ladderButton.setEnabled(false);
        if(game.isBatteringRamOnCircleSpace())
            batteringRamButton.setEnabled(true);
        else
            batteringRamButton.setEnabled(false);
        if(game.isSiegeTowerOnCircleSpace())
            siegeTowerButton.setEnabled(true);
        else
            siegeTowerButton.setEnabled(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(game.getState() instanceof Wait_Boiling){
            setVisible(true);
            setButtons();
        }else
            setVisible(false);
    }
}
