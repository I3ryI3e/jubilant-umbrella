package UI.Graphics;

import Model.ObservableGame;
import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Draw_Card;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MainGameBoard extends JPanel implements Observer, ConstantsGUI {
    private ObservableGame game;
    private BottomBox bottomBox;
    private TopBox topBox;

    public MainGameBoard(ObservableGame game) {
        super();
        this.game=game;
        game.addObserver(this);
        setVisible(false);
        createGraphicsObjects();
        addGraphicsObjects();
        update(game,null);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Image img = Images.getImage(BACKGROUND2);
        grphcs.drawImage(img, 0, 0, getParent().getWidth(),getParent().getHeight(), this);
    }
    
    private void createGraphicsObjects() {
        topBox = new TopBox(BoxLayout.X_AXIS, game);
        bottomBox= new BottomBox(BoxLayout.X_AXIS,game);
    }

    private void addGraphicsObjects() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(Box.createVerticalStrut(MARGIN));
        add(topBox);
        add(Box.createVerticalStrut(MARGIN));
        add(bottomBox);
        add(Box.createVerticalStrut(MARGIN));
    }

    @Override
    public void update(Observable o, Object arg) {
        States state= game.getState();
        if( state instanceof Wait_Draw_Card){
            setVisible(true);
        }
    }
}
