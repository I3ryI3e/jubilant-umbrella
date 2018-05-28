
package UI.Graphics;

import Model.Siege_Game;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class CardsPanel extends JPanel implements Observer,ConstantsGUI {
    private Siege_Game game;
    private String name;
    
    

    public CardsPanel(Siege_Game game,String name) {
        super();
        this.game=game;
        this.name=name;
        game.addObserver(this);
        setVisible(false);
        update(game,null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(name);
        g.drawImage(imageBoard, 0, 0,200,260, this);
    }
    

    @Override
    public void update(Observable o, Object arg) {
        //TODO
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
