package UI.Graphics;

import Model.Siege_Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DiscardPanel extends JPanel implements Observer, ConstantsGUI{
    Siege_Game game;

    public DiscardPanel(Siege_Game game) {
        super();
        this.game = game;
        game.addObserver(this);
        setVisible(true);
        setBorder(new LineBorder(Color.BLACK));
        update(game,null);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        Image imageBoard = Images.getImage("Card"+ game.getActiveCardNumber());
        g.drawImage(imageBoard, 0, 0, CARDS_WEIGHT, CARDS_HEIGHT, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();      //ELE NA TA A FAZER O PAINTCOMPONENT AUTOMATICAMENTE WTF BURRO
//        //TODO
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
