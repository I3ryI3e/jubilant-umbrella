
package UI.Graphics;

import Model.ObservableGame;
import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Draw_Card;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BoardPanel extends JPanel implements ConstantsGUI{
    protected ObservableGame game;
    private String boardName;

    public BoardPanel(ObservableGame game, String name) {
        super();
        this.game=game;
        this.boardName=name;
        setVisible(true);
        setBorder(new LineBorder(Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(boardName);
        g.drawImage(imageBoard, 0, 0, CARDS_WEIGHT, CARDS_HEIGHT, this);
    }
    
}
