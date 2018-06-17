package UI.Graphics;

import Model.ObservableGame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DiscardPanel extends JPanel implements Observer, ConstantsGUI{
    ObservableGame game;

    public DiscardPanel(ObservableGame game) {
        super();
        this.game = game;
        game.addObserver(this);
        setVisible(true);
        setOpaque(false);
        setBorder(new LineBorder(Color.BLACK));
        update(game,null);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Stroke oldStroke= ((Graphics2D)g).getStroke();
        Stroke newStroke= new BasicStroke(3);
        Image imageBoard = Images.getImage("Card"+ game.getActiveCardNumber());
        g.drawImage(imageBoard, 0, 0, CARDS_WIDTH, CARDS_HEIGHT, this);
        if(imageBoard!=null){
            ((Graphics2D)g).setColor(Color.red);
            ((Graphics2D)g).setStroke(newStroke);
            g.drawRoundRect(1, 1+(91*game.getGameDay()), CARDS_WIDTH-3, CARDS_HEIGHT/3, 30,30);
            ((Graphics2D)g).setStroke(oldStroke);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
