
package UI.Graphics;

import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Draw_Card;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BoardPanel extends JPanel implements ConstantsGUI, Observer{
    Siege_Game game;
    String boardName;

    public BoardPanel(Siege_Game game, String name) {
        super();
        this.game=game;
        this.boardName=name;
        game.addObserver(this);
        setVisible(true);
        update(game,null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(boardName);
        g.drawImage(imageBoard, 0, 0,getParent().getWidth(),getParent().getHeight(), this);
        setBorder(new LineBorder(Color.BLACK));
    }
    
    @Override
    public void update(Observable o, Object arg) {
//        States state = game.getState();
//        if(state instanceof Wait_Draw_Card){
////            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
////            topFrame.setSize(800, 800);
//            setVisible(true);
//        }else
//            setVisible(false);
    }
}
