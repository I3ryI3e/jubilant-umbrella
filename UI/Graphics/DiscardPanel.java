package UI.Graphics;

import Model.ObservableGame;
import Model.Siege_Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
        Image imageBoard = Images.getImage("Card"+ game.getActiveCardNumber());
        g.drawImage(imageBoard, 0, 0, CARDS_WEIGHT, CARDS_HEIGHT, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
    
    
}
