package UI.Graphics;

import Model.ObservableGame;
import State_Machine.Buy_One_Action;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitBuyActionPanel extends JPanel implements Observer {
    private ObservableGame game;
    private JButton supplyOptionButton;
    private JButton moraleOptionButton;
    private JButton returnButton;

    public WaitBuyActionPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        createObjects();
        orderLayout();
        addlisteners();
    }
    
    private void createObjects() {
        supplyOptionButton= new JButton("Trade One Supply");
        moraleOptionButton= new JButton("Trade One Morale");
        returnButton= new JButton("Return");
    }
    
    private void orderLayout() {
        setLayout(new GridLayout(3, 1));
        add(supplyOptionButton);
        add(moraleOptionButton);
        add(returnButton);
    }

    private void addlisteners() {
        supplyOptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.buyAction(1);
            }
        });
        moraleOptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               game.buyAction(2);
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.returnWaitAction();
            }
        });
    }

    public void setButtons(){
        if(game.canBuyAction()){
            if(game.canDecreaseSupply())
                supplyOptionButton.setEnabled(true);
            else
                supplyOptionButton.setEnabled(false);
            if(game.canDecreaseMorale())
                moraleOptionButton.setEnabled(true);
            else
                moraleOptionButton.setEnabled(false);  
        }else{
            supplyOptionButton.setEnabled(false);
            moraleOptionButton.setEnabled(false);
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(game.getState() instanceof Buy_One_Action){
            setButtons();
            setVisible(true);
        }else{
            setVisible(false);
        }
    }
}
