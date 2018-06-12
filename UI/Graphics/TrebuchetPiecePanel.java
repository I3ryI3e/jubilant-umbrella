
package UI.Graphics;

import Model.ObservableGame;
import State_Machine.Initial_State;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class TrebuchetPiecePanel extends JPanel implements Observer,ConstantsGUI{
    private ObservableGame game;
    private String type;

    public TrebuchetPiecePanel(ObservableGame game) {
        this.game = game;
        this.type = RED_SQUARE_ICON;
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
        g.drawImage(piece, 1, 0, this);
    }
    
    private void setPosition() {
        int numberOfTrebutchet= game.getTrebutchetNumber();
        if(numberOfTrebutchet==0)
            setVisible(false);
        else{
            setVisible(true);
            setBounds(15+((numberOfTrebutchet-1)*68), 245, getPreferredSize().width, getPreferredSize().height);
        }
    }
    

    @Override
    public void update(Observable o, Object arg) {
        if(!(game.getState() instanceof Initial_State)){
            setPosition();
        }
    }

    
    
}
