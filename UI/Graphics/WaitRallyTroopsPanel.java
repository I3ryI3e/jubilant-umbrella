
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

public class WaitRallyTroopsPanel extends JPanel implements Observer{
    private ObservableGame game;
    private JButton supplyDRMButton;
    private JButton rallyTroopsNormalButton;
    private JButton returnButton;

    public WaitRallyTroopsPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        createObjects();
        orderLayout();
        registerListeners();
        update(game,null);
    }
    private void createObjects() {
        supplyDRMButton= new JButton("Rally Troops +1DRM(Use one Supply)");
        rallyTroopsNormalButton= new JButton("Rally Troops");
        returnButton= new JButton("Return");
    }

    private void orderLayout() {
        setLayout(new GridLayout(3, 1));
        add(supplyDRMButton);
        add(rallyTroopsNormalButton);
        add(returnButton);
    }
    private void registerListeners() {
        supplyDRMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.rallyPlus1DRM();
            }
        });
        rallyTroopsNormalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.normalRally();
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
        if(game.canDecreaseSupply())
            supplyDRMButton.setEnabled(true);
        else
            supplyDRMButton.setEnabled(false);
    }
    

    @Override
    public void update(Observable o, Object arg) {
       if(game.getState() instanceof Buy_One_Action){
           setVisible(true);
           setButtons();
       }else{
           setVisible(false);
       }
    }  
}
