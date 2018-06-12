
package UI.Graphics;

import Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class PlayerPiecePanel extends JPanel implements Observer, ConstantsGUI {
    private String type;
    private ObservableGame game;

    public PlayerPiecePanel(String type, ObservableGame game) {
        this.game=game;
        this.type=type;
        this.game.addObserver(this);
        setOpaque(false);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(30, 30);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image piece = Images.getImage(type);
        g.drawImage(piece, 0, 0, this);
    }
    private int getActualPos(String type){
            return 9+(Math.abs(game.getPlayerLocation(type)-4)*46);
    }
    private void setPosition() {
        int newPositionOnScreen;
        switch(type){
            case WALL_ICON:
                newPositionOnScreen = getActualPos(WALL_ICON);
                if(newPositionOnScreen<180)
                    setBounds(11, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height);
                else
                    setBounds(75,newPositionOnScreen,getPreferredSize().width,getPreferredSize().height);
                break;
            case MORALE_ICON:
                newPositionOnScreen = getActualPos(MORALE_ICON);
                setBounds(75, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height); 
                break;
            case SUPPLY_ICON:
                newPositionOnScreen = getActualPos(SUPPLY_ICON);
                if(newPositionOnScreen<180)
                    setBounds(140, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height);
                else
                    setBounds(75, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height);
                break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        setPosition();
    }
}
