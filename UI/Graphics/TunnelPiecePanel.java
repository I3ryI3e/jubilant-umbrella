
package UI.Graphics;

import Model.ObservableGame;
import State_Machine.Initial_State;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class TunnelPiecePanel extends JPanel implements Observer, ConstantsGUI{
    private ObservableGame game;
    private String type;

    public TunnelPiecePanel(ObservableGame game) {
        this.game = game;
        this.type=SOLDIER_ICON;
        this.game.addObserver(this);
        setOpaque(false);
        update(game,null);
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
    private int getActualPos(){
            return 8+(game.getSoldierLocation()*31);
    }
    private void setPosition() {
        int newPositionOnScreen;
        int yPos=0;
        newPositionOnScreen=getActualPos();
        if(game.getSoldierLocation() == 0 || game.getSoldierLocation() == 3){
            type=SOLDIER_ICON;
            newPositionOnScreen+=3;
        }else if(game.getSoldierGoing()){
            type= SOLDIER_RUN_FORWARD_ICON;
            yPos+=3;
        }else{
            type= SOLDIER_RUN_BACKWARD_ICON;
            yPos+=3;
        }
        setBounds(newPositionOnScreen, 243+yPos, getPreferredSize().width, getPreferredSize().height);
    }
    

    @Override
    public void update(Observable o, Object arg) {
        if(!(game.getState() instanceof Initial_State))
            setPosition();
    }
    
}
