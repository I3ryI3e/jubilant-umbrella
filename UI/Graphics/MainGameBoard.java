
package UI.Graphics;

import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Draw_Card;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainGameBoard extends JPanel implements Observer, ConstantsGUI {
    private Siege_Game game;
    private BottomBox bottomBox;
    private TopBox topBox;

    public MainGameBoard(Siege_Game game) {
        super();
        this.game=game;
        game.addObserver(this);
        setVisible(false);
        createGraphicsObjects();
        addGraphicsObjects();
        registerListeners();
        update(game,null);
    }
    
    private void createGraphicsObjects() {
        
        topBox = new TopBox(BoxLayout.X_AXIS, game);
        bottomBox= new BottomBox(BoxLayout.X_AXIS,game);
    }

    private void addGraphicsObjects() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(topBox);
        add(bottomBox);
    }

    private void registerListeners() {
//        //TODO
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void update(Observable o, Object arg) {
        States state= game.getState();
        if( state instanceof Wait_Draw_Card){
            setVisible(true);
//            cardsPanel.setVisible(true);
            buttonsPanel.setVisible(true);
//            enemyPanel.setVisible(true);
//            playerPanel.setVisible(true);
//            discardPanel.setVisible(true);
        }
    }

 
}
