package UI.Graphics;

import Model.Siege_Game;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class ButtonPanel extends JPanel implements Observer{
    private Siege_Game game;

    public ButtonPanel(Siege_Game game){
        super();
        this.game = game;
        game.addObserver(this);
        setVisible(true);
        setBorder(new LineBorder(Color.BLACK));
        update(game, null);
    }
    
    @Override
    public void update(Observable o, Object o1) {
        //TODO
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
