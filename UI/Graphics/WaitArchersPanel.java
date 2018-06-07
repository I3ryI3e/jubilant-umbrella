
package UI.Graphics;

import Model.Constants;
import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Archers;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitArchersPanel extends JPanel implements Observer{
    private Siege_Game game;
    private JButton ladderButton;
    private JButton batteringRamButton;
    private JButton siegeTowerButton;
    private JButton returnToMenuButton;

    public WaitArchersPanel(Siege_Game game) {
        super();
        this.game = game;
        game.addObserver(this);
        setVisible(false);
        createObjects();
        orderLayout();
        registerListeners();
        update(game,null);
        
    }
    private void createObjects(){
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
                game.archers(Constants.Enemy_Attack.LADDER);
            }
        });
        batteringRamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               game.archers(Constants.Enemy_Attack.BATTERING_RAM);
            }
        });
        siegeTowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.archers(Constants.Enemy_Attack.SIEGE_TOWER);
            }
        });
        returnToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.returnWaitAction();
            }
        });
    }
    
    private void setButtons(){
        if(game.ladderOnStartingPosition())
            setEnabled(false);
        else
            setEnabled(true);
        if(game.batteringRamOnStartingPosition())
            setEnabled(false);
        else
            setEnabled(true);
        if(game.siegeTowerExists()){
            if(game.siegeTowerOnStartingPosition())
                setEnabled(false);
            else
                setEnabled(true);
        }else
            setEnabled(false);
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        States state = game.getState();
        if(state instanceof Wait_Archers){
            setVisible(true);
            setButtons();
        }else
            setVisible(false);
    }
}
