
package UI.Graphics;

import Model.Siege_Game;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class DeckPanel extends JPanel implements Observer,ConstantsGUI {
    private Siege_Game game;
    
    public DeckPanel(Siege_Game game) {
        super();
        this.game=game;
        game.addObserver(this);
        setVisible(true);
        update(game,null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(CARD_BACK);
        g.drawImage(imageBoard, 0, 0,200,260, this);
    }
    

    @Override
    public void update(Observable o, Object arg) {
        //TODO
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
